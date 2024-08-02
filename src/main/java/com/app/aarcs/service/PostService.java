package com.app.aarcs.service;

import com.app.aarcs.controller.requests.posts.PostDeleteRequest;
import com.app.aarcs.controller.requests.posts.PostInsertRequest;
import com.app.aarcs.controller.requests.posts.PostUpdateRequest;
import com.app.aarcs.controller.responses.posts.PostData;
import com.app.aarcs.exception.ServiceException;
import com.app.aarcs.mappers.db.PostDbMapper;
import com.app.aarcs.mappers.object.PostObjectMapper;
import com.app.aarcs.model.Posts;
import com.app.aarcs.settings.ServiceManager;
import com.app.aarcs.util.FileUtil;
import com.app.aarcs.util.LoggingUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

	private final PostDbMapper postDbMapper;

	private final PostObjectMapper postObjectMapper;

	@Autowired
	private PostService(PostDbMapper postDbMapper, PostObjectMapper postObjectMapper) {
		this.postDbMapper = postDbMapper;
		this.postObjectMapper = postObjectMapper;
	}

	public void add(PostInsertRequest request) {
		try {
			Posts posts = postObjectMapper.newPostRequestToPostObject(request);
			posts.setPic(FileUtil.saveFile(request.getFile(), "posts"));
			postDbMapper.insert(posts);
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error saving new post");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.POST_SAVE_ERROR);
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error occurred while saving post data");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public List<PostData> getAll() {
		try {
			return postDbMapper.getAll();
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error saving new post");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.POST_FETCH_ERROR);
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error occurred while fetching post data");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public void updatePost(PostUpdateRequest request) {
		try {
			if(postDbMapper.updatePost(postObjectMapper.updatePostRequestToPostObject(request))==0) {
				LoggingUtil.printInfo(this.getClass(), "No post found to update");
				throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.NO_POST_ERROR);
			}
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error updating post date");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.POST_UPDATE_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error occurred while updating post data");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public void deletePost(PostDeleteRequest request) {
		try {
			if(postDbMapper.deletePost(postObjectMapper.deletePostRequestToPostObject(request))==0) {
				LoggingUtil.printInfo(this.getClass(), "No post found to delete");
				throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.NO_POST_ERROR);
			}
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error deleting post date");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.PRODUCT_DELETE_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error occurred while deleting post data");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}
}
