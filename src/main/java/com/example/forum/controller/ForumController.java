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
import com.example.forum.dao.ForumRepository;
import com.example.forum.model.ForumPost;
import com.example.forum.model.User;

@RestController
@RequestMapping("/api")
public class ForumController {

	@Autowired
	ForumRepository forumRepository;
	
	// Get all forum Post
	@GetMapping("/forumPost/all")
	public List<ForumPost> getAllForumPost(){
		return forumRepository.findAll();
	}
	
	// Create a new Forum Post
	@PostMapping("/forumPost/new")
	public ForumPost createForumPost(@Valid @RequestBody ForumPost forumPost) {
		return forumRepository.save(forumPost);
	}
	
	// Get a single Forum Details
	public ForumPost getForumPostByUserId(@PathVariable(value="id") Long forumPostId) {
		return forumRepository.findById(forumPostId)
				.orElseThrow(() -> new ResourceNotFoundException("ForumPost", "id", forumPostId));
	}
	
	// Update a Forum Post
		@PutMapping("/forumPost/{id}")
		public ForumPost updatedForumPost(@PathVariable(value = "id") Long forumPostId,
		                                        @Valid @RequestBody ForumPost forumPost) {

			ForumPost forumPost1 = forumRepository.findById(forumPostId)
		            .orElseThrow(() -> new ResourceNotFoundException("ForumPost", "id", forumPostId));

			forumPost1.setTitle(forumPost1.getTitle());

			ForumPost updatedForumPost = forumRepository.save(forumPost1);
		    return updatedForumPost;
		}
	
	// Delete a Forum Post
		@DeleteMapping("/forumPost/{id}")
		public ResponseEntity<?> deleteForumPost(@PathVariable(value = "id") Long forumPostId) {
			ForumPost forumPost = forumRepository.findById(forumPostId)
		            .orElseThrow(() -> new ResourceNotFoundException("ForumPost", "id", forumPostId));

		    forumRepository.delete(forumPost);

		    return ResponseEntity.ok().build();
		}
	
	
	
	
}
