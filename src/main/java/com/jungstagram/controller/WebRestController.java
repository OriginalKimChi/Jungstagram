package com.jungstagram.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jungstagram.domain.Post;
import com.jungstagram.domain.PostRepository;
import com.jungstagram.domain.User;
import com.jungstagram.domain.UserRepository;
import com.jungstagram.dto.PostDto;
import com.jungstagram.dto.UserDto;
import com.jungstagram.service.PostService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostRepository postRepo;
	private PostService postService;
	private UserRepository userRepo;
	
	@GetMapping("/post")
	public List<Post> getPostList() {
		return postRepo.findAll();
	}
	
	@PostMapping("/post")
	public void savePost(@RequestBody PostDto dto) {
		// session 구현 후 id 적용
		String userId = "testId";
		postService.save(dto, userId);
	}
	
	@GetMapping("/user")
	public User getUser(@RequestParam String userId) {
		return userRepo.findById(userId).get();
	}
	
	@PostMapping("/user")
	public void saveUser(@RequestBody UserDto dto) {
		userRepo.save(dto.toEntity());
	}
	
	@GetMapping("/post/my")
	public List<Post> getMyPost() {
		//session 구현
		User user = userRepo.findById("testId").get();
		return user.getPostList();
	}
	
	@GetMapping("/post/{postId}")
	public Post getPost(@PathVariable("postId") Long postId) {
		return postRepo.findById(postId).get();
	}
	
	@DeleteMapping("/post/{postId}")
	public void deletePost(@PathVariable("postId") Long postId) {
		postRepo.deleteById(postId);
	}
}
