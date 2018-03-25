package com.example.forum.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.forum.model.ForumPost;

@Repository
public interface ForumRepository extends JpaRepository<ForumPost, Long>{

}
