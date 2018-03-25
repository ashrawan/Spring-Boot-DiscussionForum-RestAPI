package com.example.forum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.forum.ResourceNotFoundException;
import com.example.forum.dao.CommentRepository;
import com.example.forum.model.Comment;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	CommentRepository commentRepository;
	
	// Get all forum Post
	@GetMapping("/comment/all")
	public List<Comment> getAllComment(){
		return commentRepository.findAll();
	}
	
	// Create a new Forum Post
	@PostMapping("/comment/new")
	public Comment createComment(@Valid @RequestBody Comment comment) {
		return commentRepository.save(comment);
	}
	
	// Get a single Forum Details
	public Comment getCommentByUserId(@PathVariable(value="id") Long commentId) {
		return commentRepository.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
	}
	
	// Update a Forum Post
		@PutMapping("/Comment/{id}")
		public Comment updatedComment(@PathVariable(value = "id") Long commentId,
		                                        @Valid @RequestBody Comment comment) {

			Comment comment1 = commentRepository.findById(commentId)
		            .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

			comment1.setMessage(comment1.getMessage());

			Comment updatedComment = commentRepository.save(comment1);
		    return updatedComment;
		}
	
	// Delete a Forum Post
		@DeleteMapping("/Comment/{id}")
		public ResponseEntity<?> deleteComment(@PathVariable(value = "id") Long commentId) {
			Comment comment = commentRepository.findById(commentId)
		            .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

		    commentRepository.delete(comment);

		    return ResponseEntity.ok().build();
		}
		
}