package com.app.aarcs.controller.requests.posts;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PostInsertRequest {

	private String title;
	private String summary;
	private String userId;
	private MultipartFile file;
}
