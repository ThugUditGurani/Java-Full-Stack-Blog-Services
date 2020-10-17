package com.professorgeeks.mainservice.service;

import com.professorgeeks.mainservice.dto.PostRequest;
import com.professorgeeks.mainservice.model.Post;
import com.professorgeeks.mainservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void postNewInfo(PostRequest postRequest) {
        Post post = new Post();
        post.setId(postRequest.getId());
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setUsername(postRequest.getUsername());
        postRepository.save(post);
    }

    public List<PostRequest> getAllInfoDetails() {
        List<Post> allPost = postRepository.findAll();
        return allPost.stream().map(this::getPostRequest).collect(Collectors.toList());
    }

    private PostRequest getPostRequest(Post post){
        PostRequest postRequest = new PostRequest();
        postRequest.setId(post.getId());
        postRequest.setTopicList(post.getTopicList());
        postRequest.setContent(post.getContent());
        postRequest.setTitle(post.getTitle());
        postRequest.setUsername(post.getUsername());
        return postRequest;
    }

    public PostRequest getPost(Long id) {
        Post post = postRepository.getOne(id);
        return getPostRequest(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
