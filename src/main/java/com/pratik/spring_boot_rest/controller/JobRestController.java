package com.pratik.spring_boot_rest.controller;

import com.pratik.spring_boot_rest.model.JobPost;
import com.pratik.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobRestController {


    @Autowired
    private JobService jobService;

    @GetMapping("jobposts")
//    @GetMapping(path = "jobposts", produces = {"application/json"}) // only gives response in json
    public List<JobPost> returnAllJobPosts(){
        return jobService.returnAllJobPosts();
    }


    @GetMapping("jobposts/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
       return jobService.getJob(postId);
    }

    //@PostMapping("jobposts")
    @PostMapping(path = "jobposts", consumes = {"application/xml"})//only consumses xml data restricts json
//    Content-Type 'application/json' is not supported]
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
