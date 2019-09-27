package com.FoodGramServer.FoodGramServer.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodGramServer.FoodGramServer.models.Comment;




/**
 * JPA repository for Accounts
 *
 * @author Swechha Ghimire and Alexis Cordts
 *
 */

public interface CommentRepo extends JpaRepository<Comment, Long> {
	
	
	//we're gonna have to query the FRICK out of this once we figure
	// the database
//    @Query(value = "SELECT * FROM comments where comments = \", nativeQuery = true)
//    Collection<Comment> getComments(long userComment);
//	
//	
	
	
	
	
	
	
}

