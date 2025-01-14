package com.pratik.spring_boot_rest.repo;


import com.pratik.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    List<JobPost>  findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);
}


//
//// method to return all JobPosts
//public List<JobPost> returnAllJobPosts() {
//	return jobs;
//}
//
//// method to save a job post object into arrayList
//public void addJobPost(JobPost job) {
//	jobs.add(job);
//
//}
//
//
//public JobPost getJob(int postId) {
//	for(JobPost job:jobs) {
//		if (job.getPostId() == postId) {
//			return job;
//		}
//	}
//	return null;
//}
//
//public void updateJob(JobPost jobPost) {
//	for(JobPost jobPost1:jobs ){
//		if(jobPost1.getPostId() == jobPost.getPostId()){
//			jobPost1.setPostProfile(jobPost.getPostProfile());
//			jobPost1.setPostDesc(jobPost.getPostDesc());
//			jobPost1.setPostTechStack(jobPost.getPostTechStack());
//			jobPost1.setReqExperience(jobPost.getReqExperience());
//		}
//	}
//}
//
//
////
////When jobs.remove(jobPost) is called, the list structure changes.
////The implicit iterator used by the for-each loop no longer knows about this change.
////This causes the iterator to throw a ConcurrentModificationException.
////Directly modifying the list means using methods like remove(), add(), or clear()
////	on the list itself while it’s being iterated. This violates the iterator’s fail-fast policy.
////	To avoid this, use techniques like explicit iterators, removeIf, or iterate over a copy of the list.
////	public void deleteJob(int postId) {
////		for(JobPost jobPost:jobs){
////			if(jobPost.getPostId() == postId){
////				jobs.remove(jobPost);
////			}
////		}
////	}
//
//public void deleteJob(int postId) {
//	jobs.removeIf(jobPost -> jobPost.getPostId() == postId);
//}