package com.app.aarcs.settings;

import com.app.aarcs.exception.ServiceExceptionFactory;
import org.springframework.http.HttpStatus;

public class ServiceManager {

	private ServiceManager() {}

	public static final ServiceExceptionFactory exceptionFactory;

	public static class ErrorCode {

		private ErrorCode() {}

		public static final String GENERIC_ERROR = "GENERIC_ERROR";
		public static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";

		public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
		public static final String NOT_UNIQUE_USER_CREDENTIALS = "NOT_UNIQUE_USER_CREDENTIALS";
		public static final String SIGNUP_ERROR = "SIGNUP_ERROR";
		public static final String LOGIN_ERROR = "LOGIN_ERROR";

		public static final String MARKET_FETCH_ERROR = "MARKET_FETCH_ERROR";
		public static final String MARKET_DATA_INSERT_ERROR = "MARKET_DATA_INSERT_ERROR";
		public static final String FILE_SAVE_ERROR = "FILE_SAVE_ERROR";
		public static final String EMPTY_FILE_ERROR = "EMPTY_FILE_ERROR";
		public static final String PRODUCT_UPDATE_ERROR = "PRODUCT_UPDATE_ERROR";
		public static final String NO_PRODUCT_ERROR = "NO_PRODUCT_ERROR";
		public static final String PRODUCT_DELETE_ERROR = "PRODUCT_DELETE_ERROR";

		public static final String POST_SAVE_ERROR = "POST_SAVE_ERROR";
		public static final String POST_FETCH_ERROR = "POST_FETCH_ERROR";
		public static final String POST_UPDATE_ERROR = "POST_UPDATE_ERROR";
		public static final String NO_POST_ERROR = "NO_POST_ERROR";
		public static final String POST_DELETE_ERROR = "POST_DELETE_ERROR";

		public static final String COMMENT_SAVE_ERROR = "COMMENT_SAVE_ERROR";
		public static final String COMMENT_FETCH_ERROR = "COMMENT_FETCH_ERROR";
		public static final String COMMENT_UPDATE_ERROR = "COMMENT_UPDATE_ERROR";
		public static final String NO_COMMENT_ERROR = "NO_COMMENT_ERROR";
		public static final String COMMENT_DELETE_ERROR = "COMMENT_DELETE_ERROR";
	}

	public static class ErrorMessage {

		private ErrorMessage() {}

		public static final String GENERIC_ERROR = "Generic error has occurred";
		public static final String UNKNOWN_ERROR = "An unknown error has been occurred while processing";

		public static final String USER_NOT_FOUND = "Could not find user with given credentials";
		public static final String NOT_UNIQUE_USER_CREDENTIALS = "Phone or mail id is already registered";
		public static final String SIGNUP_ERROR = "Error while signing up";
		public static final String LOGIN_ERROR = "Error while logging in";

		public static final String MARKET_FETCH_ERROR = "Error while fetching market data";
		public static final String MARKET_DATA_INSERT_ERROR = "Error while inserting market data";
		public static final String FILE_SAVE_ERROR = "Error saving the uploaded file";
		public static final String EMPTY_FILE_ERROR = "File uploaded is empty";
		public static final String PRODUCT_UPDATE_ERROR = "Error while updating product details";
		public static final String NO_PRODUCT_ERROR = "No product with given details";
		public static final String PRODUCT_DELETE_ERROR = "Error while deleting the product";

		public static final String POST_SAVE_ERROR = "Error saving the post";
		public static final String POST_FETCH_ERROR = "Error while fetching post data";
		public static final String POST_UPDATE_ERROR = "Error while updating post";
		public static final String NO_POST_ERROR = "No post with given details";
		public static final String POST_DELETE_ERROR = "Error while deleting the post";

		public static final String COMMENT_SAVE_ERROR = "Error saving the comment";
		public static final String COMMENT_FETCH_ERROR = "Error while fetching comments";
		public static final String COMMENT_UPDATE_ERROR = "Error while updating comment";
		public static final String NO_COMMENT_ERROR = "No comment with given details";
		public static final String COMMENT_DELETE_ERROR = "Error while deleting comment";
	}

	static {
		exceptionFactory = new ServiceExceptionFactory();
		exceptionFactory.add(ErrorCode.GENERIC_ERROR, ErrorMessage.GENERIC_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.UNKNOWN_ERROR, ErrorMessage.UNKNOWN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

		exceptionFactory.add(ErrorCode.NOT_UNIQUE_USER_CREDENTIALS, ErrorMessage.NOT_UNIQUE_USER_CREDENTIALS, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.USER_NOT_FOUND, ErrorMessage.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
		exceptionFactory.add(ErrorCode.SIGNUP_ERROR, ErrorMessage.SIGNUP_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.LOGIN_ERROR, ErrorMessage.LOGIN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

		exceptionFactory.add(ErrorCode.MARKET_FETCH_ERROR, ErrorMessage.MARKET_FETCH_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.MARKET_DATA_INSERT_ERROR, ErrorMessage.MARKET_DATA_INSERT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.FILE_SAVE_ERROR, ErrorMessage.FILE_SAVE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.PRODUCT_UPDATE_ERROR, ErrorMessage.PRODUCT_UPDATE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.NO_PRODUCT_ERROR, ErrorMessage.NO_PRODUCT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.EMPTY_FILE_ERROR, ErrorMessage.EMPTY_FILE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.PRODUCT_DELETE_ERROR, ErrorMessage.PRODUCT_DELETE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

		exceptionFactory.add(ErrorCode.POST_SAVE_ERROR, ErrorMessage.POST_SAVE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.POST_FETCH_ERROR, ErrorMessage.POST_FETCH_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.POST_UPDATE_ERROR, ErrorMessage.POST_UPDATE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.NO_POST_ERROR, ErrorMessage.NO_POST_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.POST_DELETE_ERROR, ErrorMessage.POST_DELETE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

		exceptionFactory.add(ErrorCode.COMMENT_SAVE_ERROR, ErrorMessage.COMMENT_SAVE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.COMMENT_FETCH_ERROR, ErrorMessage.COMMENT_FETCH_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.COMMENT_UPDATE_ERROR, ErrorMessage.COMMENT_UPDATE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.NO_COMMENT_ERROR, ErrorMessage.NO_COMMENT_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		exceptionFactory.add(ErrorCode.COMMENT_DELETE_ERROR, ErrorMessage.COMMENT_DELETE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);


	}
}
