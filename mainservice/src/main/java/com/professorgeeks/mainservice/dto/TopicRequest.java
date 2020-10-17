package com.professorgeeks.mainservice.dto;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class TopicRequest {

    private Long id;
    private String titleTopic;
    private String contentTopic;

}
