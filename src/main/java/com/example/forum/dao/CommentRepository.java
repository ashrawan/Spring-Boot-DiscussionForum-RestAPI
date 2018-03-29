package com.example.forum.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.forum.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	@Query(value = "SELECT * FROM comment c where c.post_id = ?1", nativeQuery = true)
    public List<Comment> findByPostId(Long postId);
}
