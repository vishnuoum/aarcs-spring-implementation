package com.app.aarcs.service;

import com.app.aarcs.controller.requests.comments.CommentDeleteRequest;
import com.app.aarcs.controller.requests.comments.CommentGetRequest;
import com.app.aarcs.controller.requests.comments.CommentInsertRequest;
import com.app.aarcs.controller.requests.comments.CommentUpdateRequest;
import com.app.aarcs.controller.responses.comments.CommentData;
import com.app.aarcs.exception.ServiceException;
import com.app.aarcs.mappers.db.CommentDbMapper;
import com.app.aarcs.mappers.object.CommentObjectMapper;
import com.app.aarcs.settings.ServiceManager;
import com.app.aarcs.util.LoggingUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

	private final CommentDbMapper commentDbMapper;
	private final CommentObjectMapper commentObjectMapper;

	@Autowired
	private CommentService(CommentDbMapper commentDbMapper, CommentObjectMapper commentObjectMapper) {
		this.commentDbMapper = commentDbMapper;
		this.commentObjectMapper = commentObjectMapper;
	}

	public void add(CommentInsertRequest request) {
		try {
			commentDbMapper.insert(commentObjectMapper.insertRequestToCommentObject(request));
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error adding new comment");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.COMMENT_SAVE_ERROR);
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error while adding new comment");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public List<CommentData> getComments(CommentGetRequest request) {
		try {
			if(null != request && null != request.getId()) {
				return commentDbMapper.getComments(commentObjectMapper.getRequestToCommentObject(request));
			}
			LoggingUtil.printInfo(this.getClass(), "No comments for given post");
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.NO_COMMENT_ERROR);
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error fetching comments");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.COMMENT_FETCH_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error while fetching comments");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public void updateComment(CommentUpdateRequest request) {
		try {
			if(commentDbMapper.updateComment(commentObjectMapper.updateRequestToCommentObject(request))==0) {
				LoggingUtil.printInfo(this.getClass(), "No comment with given details");
				throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.NO_COMMENT_ERROR);
			}
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error updating the comment");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.COMMENT_UPDATE_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error while adding new comment");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public void deleteComment(CommentDeleteRequest request) {
		try {
			if(commentDbMapper.deleteComment(commentObjectMapper.deleteRequestToCommentObject(request))==0) {
				LoggingUtil.printInfo(this.getClass(), "No comment with given details");
				throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.NO_COMMENT_ERROR);
			}
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error deleting the comment");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.COMMENT_DELETE_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error while adding new comment");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}
}
