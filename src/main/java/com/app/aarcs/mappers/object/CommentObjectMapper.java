package com.app.aarcs.mappers.object;

import com.app.aarcs.controller.requests.comments.CommentDeleteRequest;
import com.app.aarcs.controller.requests.comments.CommentGetRequest;
import com.app.aarcs.controller.requests.comments.CommentInsertRequest;
import com.app.aarcs.controller.requests.comments.CommentUpdateRequest;
import com.app.aarcs.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentObjectMapper {

	Comment insertRequestToCommentObject(CommentInsertRequest request);
	Comment updateRequestToCommentObject(CommentUpdateRequest request);
	Comment deleteRequestToCommentObject(CommentDeleteRequest request);
	Comment getRequestToCommentObject(CommentGetRequest request);
}
