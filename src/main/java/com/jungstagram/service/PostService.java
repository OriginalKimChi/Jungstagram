package com.jungstagram.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jungstagram.domain.PostRepository;
import com.jungstagram.dto.PostDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {

	private PostRepository postRepo;
	
	@Transactional
	public Long save(PostDto dto, String userId) {
		return postRepo.save(dto.toEntity(userId)).getId();
	}
}
