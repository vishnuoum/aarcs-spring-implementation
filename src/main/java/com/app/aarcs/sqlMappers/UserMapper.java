package com.app.aarcs.sqlMappers;

import com.app.aarcs.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAllUsers();
    Integer register(User user);
    Integer login(User user);
    User getUser(String id);
}
