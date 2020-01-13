package com.jungstagram.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {
	
	@Id
	@Column(name="member_id")
	private String id;
	private String password;
	private String userName;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Post> postList = new ArrayList<Post>();
	
	@Builder
	public User(String id, String password, String userName) {
		this.id = id;
		this.password = password;
		this.userName = userName;
	}

}
