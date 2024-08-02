package com.app.aarcs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

	private String id;
	private String response;
	private String userId;
	private String postId;
	private String commentDate;
}
