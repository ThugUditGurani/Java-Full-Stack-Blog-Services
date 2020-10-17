package com.professorgeeks.mainservice.dto;

import com.professorgeeks.mainservice.model.Home;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class TopicRequest {

    private Long id;
    private String titleTopic;
    private String contentTopic;
    //private Home home;

}
