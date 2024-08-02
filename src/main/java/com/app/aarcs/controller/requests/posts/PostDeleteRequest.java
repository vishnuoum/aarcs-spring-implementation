package com.app.aarcs.controller.requests.posts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDeleteRequest {

	private String id;
	private String userId;
}
