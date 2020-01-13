package com.jungstagram.dto;

import com.jungstagram.domain.Post;
import com.jungstagram.domain.UserRepository;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private UserRepository userRepo;

	private String title;
	private String content;
	private UserDto userDto;
	
	@Builder
	public PostDto(String title, String content, UserDto userDto) {
		this.title = title;
		this.content = content;
		this.userDto = userDto;
	}
	
	public Post toEntity(String userId) {
		return Post.builder()
				.title(title)
				.content(content)
				.user(userRepo.findById(userId).get())
				.build();
	}
}
