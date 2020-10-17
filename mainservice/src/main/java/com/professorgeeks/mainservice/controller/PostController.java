package com.professorgeeks.mainservice.controller;

import com.professorgeeks.mainservice.dto.PostRequest;
import com.professorgeeks.mainservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/professorgeeks")
public class PostController {

    @Autowired
    PostService postService;

    /*
    * Fetching All Post Details Api form Database
    * */
    @GetMapping("/getAllPosts")
    public ResponseEntity<List<PostRequest>> getAllPostDetails(){
        return new ResponseEntity<List<PostRequest>>(postService.getAllInfoDetails(),HttpStatus.OK);
    }

    /*
    * Adding Post Details and Updating Post Details if Already exits into Database
    * */
    @PostMapping("/addPost")
    public ResponseEntity addNewPost(@RequestBody PostRequest postRequest){
        postService.postNewInfo(postRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    /*
    * Deleting particular Posts Details from Database
    * */
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity deletePost(@PathVariable @RequestBody Long id){
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    * Fetching particular Posts Details From Database
    * */
    @GetMapping("/getPost/{id}")
    public ResponseEntity<PostRequest> getPostDetails(@PathVariable @RequestBody Long id){
        return new ResponseEntity<PostRequest>(postService.getPost(id),HttpStatus.OK);
    }


}
