package com.app.aarcs.controller.responses.comments;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentData {

    private String id;
    private String response;
    private boolean enabled;
    private String username;
    private String commentDate;
}
