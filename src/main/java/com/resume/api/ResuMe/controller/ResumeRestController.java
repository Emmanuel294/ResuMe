package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.Resume;
import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.service.IResumeService;
import com.resume.api.ResuMe.service.IUserService;
import com.resume.api.ResuMe.web.responses.Resumes.ResumesResponse;
import com.resume.api.ResuMe.web.responses.Users.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResumeRestController {

    @Autowired
    IResumeService resumeService;

    @Autowired
    IUserService userService;

    @GetMapping("/resumes")
    public List<Resume> resumesAll(){
        return resumeService.findAll();
    }

    @GetMapping("/resumes/{id}")
    public ResponseEntity<ResumesResponse> resumes(@PathVariable Long id){
        List<Resume> resumes = resumeService.findAllByUserId(id);
        if(resumes != null && resumes.size() > 0){
            return new ResponseEntity<ResumesResponse>(new ResumesResponse(resumes,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }

        return new ResponseEntity<ResumesResponse>(new ResumesResponse(resumes,HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

    @PostMapping("/resumes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Resume create(@RequestBody Resume resume, @PathVariable Long id){
        User user = userService.findById(id);
        resume.setUser(user);
        return resumeService.save(resume);
    }

    @DeleteMapping("/resumes/{id}")
    public void delete(@PathVariable Long id){
        resumeService.delete(id);
    }

}
