package com.jungstagram.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추
@Getter
@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 500, nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Builder
	public Post(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.createDate = new Date();
		this.user = user;
	}
}
