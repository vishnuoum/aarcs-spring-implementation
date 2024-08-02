package com.app.aarcs.controller.requests.comments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentInsertRequest {

	private String response;
	private String userId;
	private String postId;
}
