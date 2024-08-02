package com.app.aarcs.mappers.db;

import com.app.aarcs.controller.responses.comments.CommentData;
import com.app.aarcs.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDbMapper {

	void insert(Comment comment);
	List<CommentData> getComments(Comment comment);
	int updateComment(Comment comment);
	int deleteComment(Comment comment);
}
