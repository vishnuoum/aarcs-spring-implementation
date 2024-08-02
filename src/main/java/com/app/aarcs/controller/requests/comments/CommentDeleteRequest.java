package com.app.aarcs.controller.requests.comments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDeleteRequest {

	private String id;
	private String userId;
	private String postId;
	private String response;
}
