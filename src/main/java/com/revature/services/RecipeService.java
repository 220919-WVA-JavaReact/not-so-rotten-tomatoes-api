package com.revature.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.revature.dtos.RecipeDTO;
import com.revature.entities.Category;
import com.revature.entities.Recipe;
import com.revature.entities.User;
import com.revature.exceptions.UserNotFoundException;
import com.revature.repositories.UserRepository;
import com.revature.repositories.RecipeRepository;
import com.revature.exceptions.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

@Service
public class RecipeService {

    RecipeRepository rr;
    UserRepository ur;

    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    private AmazonS3 s3Client;

    public String uploadFile(MultipartFile file) {
        File fileObject = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis()+"_"+file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObject));

        //delete file once uploaded
        fileObject.delete();

        return fileName;
    }
//    public void uploadFile(String fileName, InputStream inputStream) {
//        try {
//            s3Client.putObject(new PutObjectRequest(bucketName, fileName, inputStream.available()));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try(FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            System.out.println("Error converting multipartFile to file. : " + e);
        }
        return convertedFile;
    }

    @Autowired
    public RecipeService(RecipeRepository rr, UserRepository ur, AmazonS3 s3Client) {

        this.rr = rr;
        this.ur = ur;
        this.s3Client = s3Client;
    }

    public List<Recipe> getAllRecipes() {
        return rr.findAll();
    }

    public Recipe createRecipe(RecipeDTO recipe, MultipartFile file) {

        User u = ur.findById(recipe.getUserid()).orElseThrow(UserNotFoundException::new);
        if (file != null && !file.isEmpty()) {
            String fileName = uploadFile(file);

            Recipe newRecipe = new Recipe(u, recipe.getTitle(), recipe.getInstructions(), recipe.getCategory(), fileName);
            return rr.save(newRecipe);
        } else {
            Recipe newRecipe = new Recipe(u, recipe.getTitle(), recipe.getInstructions(), recipe.getCategory());
            newRecipe.setFilename("noimage.jpg");
            return rr.save(newRecipe);
        }

    }

    public Recipe getRecipeById(int id) {
        Recipe r = rr.findById(id).orElseThrow(RecipeNotFoundException::new);
        return r;
    }

    public Recipe updateRecipe(int id, Recipe update) throws RecipeNotFoundException{

        //extract new values out of update
       // int authorint = update.getAuthor().getUser_id();
        String newTitle = update.getRecipe_name();
        String newInstructions = update.getInstructions();
        Category newCategory = update.getCategory();
        Recipe newRecipe = null;
        try {
             newRecipe = rr.getOne(id);
             //note: error handling is already taken care of, no need to check this value.
            // Will return a 400 bad request, saying
            //that no recipe exists with that id.

             //set new infos, save to db
            //newRecipe.setAuthor(authorint);
            newRecipe.setRecipe_name(newTitle);
            newRecipe.setInstructions(newInstructions);
            newRecipe.setCategory(newCategory);

            newRecipe = rr.save(newRecipe);
        } catch (RecipeNotFoundException r){
            r.getClass(); //currently ignored. Proceed?
        }
    return newRecipe;

    }

    public List<Recipe> getRecipesByAuthorId(int id){
        User u = ur.findById(id).orElseThrow(UserNotFoundException::new);
        return rr.findRecipesByAuthor(u);
    }

    public List<Recipe> findByRecipeContains(String searchTerm) {
        List<Recipe> res = rr.findByRecipeContains(searchTerm.toLowerCase());
        return res;
    }
}
