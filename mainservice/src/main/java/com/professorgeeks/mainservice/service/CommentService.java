package com.professorgeeks.mainservice.service;

import com.professorgeeks.mainservice.dto.CommentRequest;
import com.professorgeeks.mainservice.model.Comment;
import com.professorgeeks.mainservice.repository.CommentRepository;
import com.professorgeeks.mainservice.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TopicRepository topicRepository;

    public void postComments(Long topicId,CommentRequest commentRequest) {

        topicRepository.findById(topicId).map(topic -> {
            Comment comment = new Comment();
            comment.setText(commentRequest.getText());
            comment.setUsername(commentRequest.getUsername());
            comment.setTopic(topic);
            return commentRepository.save(comment);
        });


    }


    public Object getComments(Long topicId) {
        return topicRepository.findById(topicId).map(topic -> {
           return topic.getComments();
        });
    }
}
