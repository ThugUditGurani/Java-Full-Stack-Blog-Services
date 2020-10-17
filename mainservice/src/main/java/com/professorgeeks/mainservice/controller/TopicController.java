package com.professorgeeks.mainservice.controller;

import com.professorgeeks.mainservice.dto.TopicRequest;
import com.professorgeeks.mainservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/professorgeeks/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/addTopic")
    public ResponseEntity addNewTopicPost(@RequestBody TopicRequest topicRequest){
        topicService.addNewTopicPost(topicRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

}
