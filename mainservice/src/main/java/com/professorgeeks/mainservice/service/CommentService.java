package com.professorgeeks.mainservice.service;

import com.professorgeeks.mainservice.dto.CommentRequest;
import com.professorgeeks.mainservice.model.Comment;
import com.professorgeeks.mainservice.model.Topic;
import com.professorgeeks.mainservice.repository.CommentRepository;
import com.professorgeeks.mainservice.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TopicRepository topicRepository;

    public void postComments(Long topicId,CommentRequest commentRequest) {

        Optional<Topic> byId = topicRepository.findById(topicId);
        Topic topic1 = byId.get();
        Comment comment = new Comment();
        comment.setText(commentRequest.getText());
        comment.setUsername(commentRequest.getUsername());
        comment.setTopic(topic1);
        commentRepository.save(comment);

    }


    public Object getComments(Long topicId) {
        Optional<Topic> byId = topicRepository.findById(topicId);
        return byId.get().getComments();
    }
}
