package com.example.forum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.forum.AllEnums.Category;
import com.example.forum.AllEnums.PostType;
import com.example.forum.AllEnums.Status;
import com.example.forum.AllEnums.SubCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="forum_post")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ForumPost {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user" , nullable=false)
	private User user;
	
	@Column(nullable = false)
	private String title;
	
	@Enumerated(EnumType.STRING)
    @Column
    private Category category;
	
	@Enumerated(EnumType.STRING)
    @Column
    private SubCategory subCategory;
	
	@Column
	private String description;
	
	@Column
	private String tags;
	
	@Enumerated(EnumType.STRING)
	@Column
	private PostType postType;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public PostType getPostType() {
		return postType;
	}

	public void setPostType(PostType postType) {
		this.postType = postType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	
}
