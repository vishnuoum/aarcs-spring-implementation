package com.app.aarcs.controller;

import com.app.aarcs.controller.requests.posts.PostDeleteRequest;
import com.app.aarcs.controller.requests.posts.PostInsertRequest;
import com.app.aarcs.controller.requests.posts.PostUpdateRequest;
import com.app.aarcs.controller.responses.posts.PostData;
import com.app.aarcs.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;

	@Autowired
	private PostController(PostService postService) {
		this.postService = postService;
	}

	@PostMapping("/add")
	public void add(@ModelAttribute PostInsertRequest request) {
		postService.add(request);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PostData>> getAll() {
		return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/updatePost")
	public void updatePost(@RequestBody PostUpdateRequest request) {
		postService.updatePost(request);
	}

	@DeleteMapping("/deletePost")
	public void deletePost(@RequestBody PostDeleteRequest request) {
		postService.deletePost(request);
	}
}
