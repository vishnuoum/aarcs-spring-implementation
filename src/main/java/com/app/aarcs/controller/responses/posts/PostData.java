package com.app.aarcs.controller.responses.posts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostData {

	private String id;
	private String title;
	private String summary;
	private String postDate;
	private String username;
	private String pic;
	private Integer commentCount;
}
