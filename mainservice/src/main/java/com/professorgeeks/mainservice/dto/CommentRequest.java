package com.professorgeeks.mainservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CommentRequest {
    private Long id;
    private String text;
    private String username;
}
