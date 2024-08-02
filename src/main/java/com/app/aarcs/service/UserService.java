package com.app.aarcs.service;

import com.app.aarcs.controller.requests.users.LoginRequest;
import com.app.aarcs.controller.requests.users.RegisterRequest;
import com.app.aarcs.exception.ServiceException;
import com.app.aarcs.mappers.db.UserDbMapper;
import com.app.aarcs.mappers.object.UserObjectMapper;
import com.app.aarcs.model.User;
import com.app.aarcs.settings.ServiceManager;
import com.app.aarcs.util.HashUtil;
import com.app.aarcs.util.LoggingUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserDbMapper userDbMapper;

	private final UserObjectMapper userObjectMapper;

	@Autowired
	private UserService(UserDbMapper userDbMapper, UserObjectMapper userObjectMapper) {
		this.userDbMapper = userDbMapper;
		this.userObjectMapper = userObjectMapper;
	}

	public String register(RegisterRequest request) {
		try {
			User user = userObjectMapper.registerRequestToUserObject(request);
			user.setPassword(HashUtil.generatePasswordHash(user.getPassword()));
			userDbMapper.insert(user);
			return HashUtil.convertToSHA1(user.getId().toString());
		} catch (DataIntegrityViolationException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error while DB insertion");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.NOT_UNIQUE_USER_CREDENTIALS);
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error while DB insertion");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.SIGNUP_ERROR);
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error occurred");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}

	public String login(LoginRequest request) {
		try {
			User user = userObjectMapper.loginRequestToUserObject(request);
			User storedUser = userDbMapper.login(user);
			if(null != storedUser && null != storedUser.getId() && null != user.getPassword() && HashUtil.validatePassword(user.getPassword(), storedUser.getPassword())) {
				return HashUtil.convertToSHA1(storedUser.getId().toString());
			}
			LoggingUtil.printInfo(this.getClass(), "User not found");
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.USER_NOT_FOUND);
		} catch (PersistenceException ex) {
			LoggingUtil.printInfo(this.getClass(), "Error while fetching data from DB");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.LOGIN_ERROR);
		} catch (ServiceException ex) {
			throw ex;
		} catch (Exception ex) {
			LoggingUtil.printInfo(this.getClass(), "Unknown error occurred");
			LoggingUtil.printError(ex.getMessage());
			throw ServiceManager.exceptionFactory.generateException(ServiceManager.ErrorCode.UNKNOWN_ERROR);
		}
	}
}
