package com.app.aarcs.mappers.db;

import com.app.aarcs.controller.responses.posts.PostData;
import com.app.aarcs.model.Posts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostDbMapper {

	void insert(Posts posts);
	List<PostData> getAll();
	int updatePost(Posts posts);
	int deletePost(Posts posts);
}
