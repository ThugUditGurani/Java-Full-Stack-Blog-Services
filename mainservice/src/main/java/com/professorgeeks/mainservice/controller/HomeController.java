package com.professorgeeks.mainservice.controller;

import com.professorgeeks.mainservice.dto.HomeRequest;
import com.professorgeeks.mainservice.model.Home;
import com.professorgeeks.mainservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/professorgeeks")
public class HomeController {

    @Autowired
    HomeService homeService;

    /*
    * Fetching All Post Details Api form Database
    * */
    @GetMapping("/getAllPosts")
    public ResponseEntity<List<HomeRequest>> getAllPostDetails(){
        return new ResponseEntity<List<HomeRequest>>(homeService.getAllInfoDetails(),HttpStatus.OK);
    }

    /*
    * Adding Post Details and Updating Post Details if Already exits into Database
    * */
    @PostMapping("/addPost")
    public ResponseEntity addNewPost(@RequestBody HomeRequest homeRequest){
        homeService.postNewInfo(homeRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    /*
    * Deleting particular Posts Details from Database
    * */
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity deletePost(@PathVariable @RequestBody Long id){
        homeService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
    * Fetching particular Posts Details From Database
    * */
    @GetMapping("/getPost/{id}")
    public ResponseEntity<HomeRequest> getPostDetails(@PathVariable @RequestBody Long id){
        return new ResponseEntity<HomeRequest>(homeService.getPost(id),HttpStatus.OK);
    }


}
