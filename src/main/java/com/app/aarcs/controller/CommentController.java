package com.app.aarcs.controller;

import com.app.aarcs.controller.requests.comments.CommentDeleteRequest;
import com.app.aarcs.controller.requests.comments.CommentGetRequest;
import com.app.aarcs.controller.requests.comments.CommentInsertRequest;
import com.app.aarcs.controller.requests.comments.CommentUpdateRequest;
import com.app.aarcs.controller.responses.comments.CommentData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.aarcs.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

	private final CommentService commentService;

	@Autowired
	private CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CommentInsertRequest request) {
		commentService.add(request);
	}

	@PostMapping("/getComments")
	public ResponseEntity<List<CommentData>> add(@RequestBody CommentGetRequest request) {
		return new ResponseEntity<>(commentService.getComments(request), HttpStatus.OK);
	}

	@PostMapping("/updateComment")
	public void updateComment(@RequestBody CommentUpdateRequest request) {
		commentService.updateComment(request);
	}

	@DeleteMapping("/deleteComment")
	public void deleteComment(@RequestBody CommentDeleteRequest request) {
		commentService.deleteComment(request);
	}
}
