package com.professorgeeks.mainservice.dto;

import com.professorgeeks.mainservice.model.Topic;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter @Setter
public class HomeRequest {

    private Long id;
    private String title;
    private String content;
    private Instant createdOn;
    private Instant UpdatedOn;
    private String username;
   // private List<Topic> topicList;
}
