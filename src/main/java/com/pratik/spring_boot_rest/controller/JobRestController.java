package com.pratik.spring_boot_rest.controller;

import com.pratik.spring_boot_rest.model.JobPost;
import com.pratik.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class JobRestController {


    @Autowired
    private JobService jobService;

    @GetMapping("jobposts")
//    @GetMapping(path = "jobposts", produces = {"application/json"}) // only gives response in json
    public List<JobPost> returnAllJobPosts(){
        return jobService.returnAllJobPosts();
    }

        @GetMapping("load")
        public String load(){
            jobService.load();
            return "sucess";
        }



    @GetMapping("jobposts/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
       return jobService.getJob(postId);
    }

    @GetMapping("jobposts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobService.search(keyword);

    }


    //@PostMapping("jobposts")
    @PostMapping(path = "jobposts", consumes = {"application/json"})//only consumses xml data if its {"application/xml"} it restricts json
//    Content-Type 'application/json' is not supported
    public void addjob(@RequestBody JobPost jobPost){
        jobService.addJobPost(jobPost);
    }

    @PutMapping("jobposts")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobposts/{postId}")
    public String deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
        return "Data has been deleted sucessfully";
    }



}
