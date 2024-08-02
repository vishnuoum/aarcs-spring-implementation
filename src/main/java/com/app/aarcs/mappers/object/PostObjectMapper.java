package com.app.aarcs.mappers.object;

import com.app.aarcs.controller.requests.posts.PostDeleteRequest;
import com.app.aarcs.controller.requests.posts.PostInsertRequest;
import com.app.aarcs.controller.requests.posts.PostUpdateRequest;
import com.app.aarcs.model.Posts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostObjectMapper {

	Posts newPostRequestToPostObject(PostInsertRequest request);

	Posts updatePostRequestToPostObject(PostUpdateRequest request);

	Posts deletePostRequestToPostObject(PostDeleteRequest request);
}
