package com.professorgeeks.mainservice.service;

import com.professorgeeks.mainservice.dto.TopicRequest;
import com.professorgeeks.mainservice.exception.ResourceNotFoundException;
import com.professorgeeks.mainservice.model.Post;
import com.professorgeeks.mainservice.model.Topic;
import com.professorgeeks.mainservice.repository.PostRepository;
import com.professorgeeks.mainservice.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private PostRepository postRepository;


    public Page<Topic> getAllTopicsByPostId(Long postId, Pageable pageable) {
        return topicRepository.findByPostId(postId,pageable);
    }


    public Object deleteTopic(Long postId, Long topicId) {
        Optional<Topic> byIdAndPostId = topicRepository.findByIdAndPostId(topicId, postId);
        topicRepository.delete(byIdAndPostId.get());
        return ResponseEntity.ok().build();
    }

    public Object addNewTopicPost(Long postId, TopicRequest topicRequest) {

        Optional<Post> byId = postRepository.findById(postId);
        Post post1 = byId.get();
        Topic topic = new Topic();
        topic.setId(topicRequest.getId());
        topic.setTitle(topicRequest.getTitleTopic());
        topic.setContent(topicRequest.getContentTopic());
        topic.setPost(post1);
        return topicRepository.save(topic);

    }
}
