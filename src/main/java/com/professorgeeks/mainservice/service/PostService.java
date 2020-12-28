package com.professorgeeks.mainservice.service;

import com.professorgeeks.mainservice.model.Post;
import com.professorgeeks.mainservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void postNewInfo(Post post) {
        postRepository.save(post);
    }

    public List<Post> getAllInfoDetails() {
       return postRepository.findAll();
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
