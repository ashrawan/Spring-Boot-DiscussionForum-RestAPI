package com.example.forum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.forum.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
