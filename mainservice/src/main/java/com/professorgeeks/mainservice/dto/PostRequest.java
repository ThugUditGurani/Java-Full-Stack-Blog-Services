package com.professorgeeks.mainservice.dto;

import com.professorgeeks.mainservice.model.Topic;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter @Setter
public class PostRequest {

    private Long id;
    private String title;
    private String content;
    private String username;
    private List<Topic> topicList;

}
