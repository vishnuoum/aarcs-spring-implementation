package com.app.aarcs.controller.requests.posts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateRequest {

	private String id;
	private String title;
	private String summary;
	private String userId;
}
