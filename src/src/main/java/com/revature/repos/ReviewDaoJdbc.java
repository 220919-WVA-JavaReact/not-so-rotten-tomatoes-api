package com.revature.repos;


import com.revature.model.ReviewModel;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoJdbc implements ReviewDao {
    @Override
    public ReviewModel createReview(ReviewModel r) {
        //need to set up connection to get ConnectionUtil working?
        try (Connection conn = ConnectionUtil.getConn()) {
            String sql = "INSERT INTO reviews (author, review_text, recipe_id) VALUES (?,?,?) RETURNING *";
            //Put ? wherever information will receive input
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //Answer ? below with parameter and variable/input
            pstmt.setInt(1, r.getAuthor());
            pstmt.setString(2, r.getReview_text());
            pstmt.setInt(3, r.getRecipe_id());
            ResultSet rs = pstmt.executeQuery();
            if (rs != null) {
                rs.next();
                int authId = rs.getInt("review_id");
                int author = rs.getInt("author");
                String text = rs.getString("review_text");
                int recipeId = rs.getInt("recipe_id");

                r = new ReviewModel(authId, author, text, recipeId);
                System.out.println("Ticket has been made, number: " + authId + ".");

            }
        } catch (SQLException e) {
            System.out.println("Review could not be created.");
            throw new RuntimeException(e);
        }
        return r;
    }

    @Override
    public ReviewModel deleteReview(ReviewModel r) {
        //need to set up connection to get ConnectionUtil working?
        try (Connection conn = ConnectionUtil.getConn()) {
            String sql = "DELETE FROM reviews WHERE author = ? AND review_id = ? RETURNING *";
            //Put ? wherever information will receive input
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //Answer ? below with parameter and variable/input
            pstmt.setInt(1, r.getAuthor());
            pstmt.setInt(2, r.getReview_id());
            ResultSet rs = pstmt.executeQuery();
            if (rs != null) {
                rs.next();
                int authId = rs.getInt("review_id");
                int author = rs.getInt("author");
                String text = rs.getString("review_text");
                int recipeId = rs.getInt("recipe_id");

                r = new ReviewModel(authId, author, text, recipeId);
                System.out.println("Review has been deleted.");

            }
        } catch (SQLException e) {
            System.out.println("Review could not be completed. Please review your id number.");
            //throw new RuntimeException(e);
        }
        return r;
    }

    @Override
    public List<ReviewModel> getAllReviews() {
        //need to set up connection to get ConnectionUtil working?
        List<ReviewModel> reviews = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConn()) {
            String sql = "SELECT * FROM reviews";
            //Put ? wherever information will receive input
            assert conn != null;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //Answer ? below with parameter and variable/input
            ResultSet rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int authId = rs.getInt("review_id");
                    int author = rs.getInt("author");
                    String text = rs.getString("review_text");
                    int recipeId = rs.getInt("recipe_id");

                    ReviewModel r = new ReviewModel(authId, author, text, recipeId);
                    reviews.add(r);
                    //System.out.println(reviews);
                }
            }
        } catch (SQLException e) {
            System.out.println("Unable to fetch reviews.");
            //throw new RuntimeException(e);
        }
        return reviews;
    }

}