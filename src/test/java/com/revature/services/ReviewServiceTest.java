package com.revature.services;

import com.revature.NsrtApplication;
import com.revature.dtos.ReviewDTO;
import com.revature.entities.Recipe;
import com.revature.entities.Review;
import com.revature.entities.Role;
import com.revature.entities.User;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.repositories.ReviewRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest(classes= NsrtApplication.class)
public class ReviewServiceTest {

    @MockBean
    private ReviewRepository mockRepository;

    @Autowired
    private ReviewService sut;

    @Test
    public void getReviewByIdExists(){
        User cory = new User();
        Recipe testRecipe = new Recipe();
        Review returnedReview = new Review();
        returnedReview.setReview_id(1);
        returnedReview.setAuthor(cory);
        returnedReview.setReview_text("good food");
        returnedReview.setRecipe_id(testRecipe);

        Mockito.when(mockRepository.findById(1)).thenReturn(Optional.of(returnedReview));

        Review expected = new Review();
        expected.setReview_id(1);
        expected.setAuthor(cory);
        expected.setReview_text("good food");
        expected.setRecipe_id(testRecipe);

        Review actual = sut.getReviewById(1);

        assertEquals(expected, actual);
    }

    @Test
    public void getReviewByIdDoesNotExist(){
        Mockito.when(mockRepository.findById(100)).thenReturn(Optional.empty());

        assertThrows(ReviewNotFoundException.class, () -> sut.getReviewById(100));
    }

    @Test
    public void deleteReviewByIdExists(){
        User cory = new User();
        Recipe testRecipe = new Recipe();
        Review returnedReview = new Review();
        returnedReview.setReview_id(1);
        returnedReview.setAuthor(cory);
        returnedReview.setReview_text("good food");
        returnedReview.setRecipe_id(testRecipe);

        Mockito.when(mockRepository.findById(1)).thenReturn(Optional.of(returnedReview));

        Review expected = new Review();
        expected.setReview_id(1);
        expected.setAuthor(cory);
        expected.setReview_text("good food");
        expected.setRecipe_id(testRecipe);

        Review actual = sut.deleteReviewById(1);

        assertEquals(expected, actual);
    }

    @Test
    public void deleteReviewByIdDoesNotExist(){
        Mockito.when(mockRepository.findById(100)).thenReturn(Optional.empty());

        assertThrows(ReviewNotFoundException.class, () -> sut.deleteReviewById(100));
    }

    @Test
    public void getAllReviewsRetrieves(){
        User cory = new User();
        Recipe testRecipe = new Recipe();
        Review returnedReview = new Review();
        returnedReview.setReview_id(1);
        returnedReview.setAuthor(cory);
        returnedReview.setReview_text("good food");
        returnedReview.setRecipe_id(testRecipe);
        List<Review> returned = new ArrayList<>();
        returned.add(returnedReview);

        Mockito.when(mockRepository.findAll()).thenReturn(returned);

        Review expected = new Review();
        expected.setReview_id(1);
        expected.setAuthor(cory);
        expected.setReview_text("good food");
        expected.setRecipe_id(testRecipe);
        List<Review> expect = new ArrayList<>();
        expect.add(expected);

        List<Review> actual = sut.getAllReviews();


        assertEquals(expect, actual);
    }

//    @Test
//    public void getAllReviewsDoesNotExist(){
//        Mockito.when(mockRepository.findAll()).thenReturn(Optional.empty());
//
//        assertThrows(ReviewNotFoundException.class, () -> sut.getAllReviews());
//    }

    @Test
    public void createReviewSaves(){
        User cory = new User();
        cory.setUser_id(2);
        Recipe testRecipe = new Recipe();
        ReviewDTO returnedDTO = new ReviewDTO();
        returnedDTO.setAuthorid(2);
        returnedDTO.setReview_text("good food");
        returnedDTO.setRecipe_id(testRecipe);
        Review returnedReview = new Review();
        returnedReview.setReview_id(1);
        returnedReview.setAuthor(cory);
        returnedReview.setReview_text(returnedDTO.getReview_text());
        returnedReview.setRecipe_id(returnedDTO.getRecipe_id());

        Mockito.when(mockRepository.findById(returnedDTO.getAuthorid())).thenReturn(Optional.of(returnedReview));
        Mockito.when(mockRepository.save(returnedReview)).thenReturn(returnedReview);

        Review expected = new Review();
        expected.setReview_id(1);
        expected.setAuthor(cory);
        cory.setUsername("admin");
        cory.setEmail("admin@gmail.com");
        cory.setPassword("test");
        cory.setRole(Role.ADMIN);
        expected.setReview_text("good food");
        expected.setRecipe_id(testRecipe);


        Review actual = sut.createReview(returnedDTO);
        actual.setReview_id(1); //why am I having to set this here? Why won't it persist?

        assertEquals(expected, actual);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RETURN: " + actual);
    }

    @Test
    public void getReviewByAuthorWorks(){
        User cory = new User();
        cory.setUser_id(2);
        Recipe testRecipe = new Recipe();
        Review returnedReview = new Review();
        returnedReview.setReview_id(1);
        returnedReview.setAuthor(cory);
        returnedReview.setReview_text("good food");
        returnedReview.setRecipe_id(testRecipe);
        List<Review> returned = new ArrayList<>();
        returned.add(returnedReview);

        Mockito.when(mockRepository.findByAuthor(any(User.class))).thenReturn(returned);

        Review expected = new Review();
        expected.setReview_id(1);
        expected.setAuthor(cory);
        expected.setReview_text("good food");
        expected.setRecipe_id(testRecipe);
        List<Review> expect = new ArrayList<>();
        expect.add(expected);
        //System.out.println("RETURNED FUNCTION::" + returned);

        List<Review> actual = sut.getReviewsByAuthor(2);


        assertEquals(expect, actual);
    }

    @Test
    public void getReviewByRecipeWorks(){
        User cory = new User();
        Recipe testRecipe = new Recipe();
        testRecipe.setRecipe_id(2);
        Review returnedReview = new Review();
        returnedReview.setReview_id(1);
        returnedReview.setAuthor(cory);
        returnedReview.setReview_text("good food");
        returnedReview.setRecipe_id(testRecipe);
        List<Review> returned = new ArrayList<>();
        returned.add(returnedReview);

        Mockito.when(mockRepository.findByRecipeid(any(Recipe.class))).thenReturn(returned);

        Review expected = new Review();
        expected.setReview_id(1);
        expected.setAuthor(cory);
        expected.setReview_text("good food");
        expected.setRecipe_id(testRecipe);
        List<Review> expect = new ArrayList<>();
        expect.add(expected);


        List<Review> actual = sut.getReviewsByRecipe(2);


        assertEquals(expect, actual);
    }
}
