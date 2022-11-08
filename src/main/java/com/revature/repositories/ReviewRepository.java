package com.revature.repositories;

import com.revature.dtos.UserDTO;
import com.revature.entities.Category;
import com.revature.entities.Recipe;
import com.revature.entities.Review;
import com.revature.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {


    List<Review> findByAuthor(User u);

    List<Review> findByRecipeid(Recipe r);
}
