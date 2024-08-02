package com.app.aarcs.mappers.object;

import com.app.aarcs.controller.requests.users.LoginRequest;
import com.app.aarcs.controller.requests.users.RegisterRequest;
import com.app.aarcs.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserObjectMapper {

	User registerRequestToUserObject(RegisterRequest request);

	@Mapping(target = "phone", source = "request.key")
	@Mapping(target = "mail", source = "request.key")
	User loginRequestToUserObject(LoginRequest request);
}
