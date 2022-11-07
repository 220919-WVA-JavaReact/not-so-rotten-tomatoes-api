package com.revature.services;

import com.revature.NsrtApplication;
import com.revature.entities.Recipe;
import com.revature.entities.Review;
import com.revature.entities.User;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.repositories.ReviewRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        Review actual = sut.getReviewById(1);

        assertEquals(expected, actual);
    }
}
