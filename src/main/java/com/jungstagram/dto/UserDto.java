package com.jungstagram.dto;

import com.jungstagram.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private String id;
	private String password;
	private String userName;
	
	public User toEntity() {
		return User.builder()
				.id(id)
				.password(password)
				.userName(userName)
				.build();
			
	}
}
