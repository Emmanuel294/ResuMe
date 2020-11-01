package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.Resume;
import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.service.IResumeService;
import com.resume.api.ResuMe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public List<Resume> resumes(@PathVariable Long id){
        return resumeService.findAllByUserId(id);
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
