package com.professorgeeks.mainservice.controller;

import com.professorgeeks.mainservice.dto.TopicRequest;
import com.professorgeeks.mainservice.model.Post;
import com.professorgeeks.mainservice.model.Topic;
import com.professorgeeks.mainservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/professorgeeks/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    /*
    * API :- Get All Topic of Posts from the database
    * */
    @GetMapping("/getTopic/{postId}/topic")
    public ResponseEntity<Page<Topic>> getAllTopicsByPostid(@PathVariable(value = "postId") Long postId, Pageable pageable){
        return new ResponseEntity<Page<Topic>>(topicService.getAllTopicsByPostId(postId,pageable),HttpStatus.OK);
    }


    /*
    * API:- Add New Topic in Posts in the Database
    * */
    @PostMapping("/addTopic/{postId}/topic")
    public ResponseEntity<List<Topic>> addNewTopicPost(@PathVariable( value = "postId") Long postId, @Validated @RequestBody TopicRequest topicRequest){

        return new ResponseEntity(topicService.addNewTopicPost(postId,topicRequest),HttpStatus.OK);
    }

    /*
    * API:- Delete Topic from the database
    * */
    @DeleteMapping("/deleteTopic/{postId}/topic/{topicId}")
    public ResponseEntity deleteTopic(@PathVariable(value = "postId") Long postId,@PathVariable (value = "topicId") Long topicId){
        return new ResponseEntity(topicService.deleteTopic(postId,topicId),HttpStatus.OK);
    }

}
