package com.app.aarcs.mappers.db;

import com.app.aarcs.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDbMapper {

	void insert(User user);
	User login(User user);
}
