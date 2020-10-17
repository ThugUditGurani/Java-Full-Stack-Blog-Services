package com.professorgeeks.mainservice.service;

import com.professorgeeks.mainservice.dto.TopicRequest;
import com.professorgeeks.mainservice.model.Home;
import com.professorgeeks.mainservice.model.Topic;
import com.professorgeeks.mainservice.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public void addNewTopicPost(TopicRequest topicRequest) {
        Topic topic = new Topic();
        topic.setId(topicRequest.getId());
        topic.setTitle(topicRequest.getTitleTopic());
        topic.setContent(topicRequest.getContentTopic());
       // topic.setHome(topicRequest.getHome());
        topicRepository.save(topic);
    }
}
