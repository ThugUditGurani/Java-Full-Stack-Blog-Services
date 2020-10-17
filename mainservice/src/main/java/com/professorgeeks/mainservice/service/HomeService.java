package com.professorgeeks.mainservice.service;

import com.professorgeeks.mainservice.dto.HomeRequest;
import com.professorgeeks.mainservice.model.Home;
import com.professorgeeks.mainservice.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    public void postNewInfo(HomeRequest homeRequest) {
        Home home  = new Home();
        home.setId(homeRequest.getId());
        home.setTitle(homeRequest.getTitle());
        home.setContent(homeRequest.getContent());
        home.setCreatedOn(Instant.now());
        home.setUpdatedOn(Instant.now());
        //home.setTopicList(homeRequest.getTopicList());
        home.setUsername(homeRequest.getUsername());
        homeRepository.save(home);
    }

    public List<HomeRequest> getAllInfoDetails() {
        List<Home> allHome = homeRepository.findAll();
        return allHome.stream().map(this::getPostRequest).collect(Collectors.toList());
    }

    private HomeRequest getPostRequest(Home home){
        HomeRequest homeRequest = new HomeRequest();
        homeRequest.setId(home.getId());
        homeRequest.setContent(home.getContent());
        homeRequest.setCreatedOn(home.getCreatedOn());
        homeRequest.setTitle(home.getTitle());
        homeRequest.setUpdatedOn(home.getUpdatedOn());
        homeRequest.setUsername(home.getUsername());
        return homeRequest;
    }

    public HomeRequest getPost(Long id) {
        Home home = homeRepository.getOne(id);
        return getPostRequest(home);
    }

    public void deletePost(Long id) {
        homeRepository.deleteById(id);
    }

}
