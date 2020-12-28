package com.professorgeeks.mainservice.controller;


import com.professorgeeks.mainservice.dto.CommentRequest;
import com.professorgeeks.mainservice.model.Comment;
import com.professorgeeks.mainservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/professorgeeks/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{topicId}/postComments")
    public ResponseEntity postComments(@PathVariable(value = "topicId") Long topicId, @RequestBody CommentRequest commentRequest){
        commentService.postComments(topicId,commentRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{topicId}/getComments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable(value = "topicId") Long topicId){
        return new ResponseEntity(commentService.getComments(topicId),HttpStatus.OK);
    }

}
