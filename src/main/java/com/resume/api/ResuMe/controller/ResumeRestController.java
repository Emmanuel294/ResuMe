package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.Resume;
import com.resume.api.ResuMe.entity.Tools;
import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.service.*;
import com.resume.api.ResuMe.web.responses.Resumes.ResumesResponse;
import com.resume.api.ResuMe.web.responses.Users.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ResumeRestController {

    @Autowired
    IResumeService resumeService;

    @Autowired
    IProjectServiceImpl projectService;

    @Autowired
    IToolsServiceImpl toolsService;

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

    @GetMapping("/resumes/{id}/{rid}")
    public ResponseEntity<ResumesResponse> resumeById(@PathVariable Long rid,@PathVariable Long id){
        Resume resume = resumeService.findById(rid);
        if(resume != null && resume.getUser().getId() == id){
            return new ResponseEntity<ResumesResponse>(new ResumesResponse(resume,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }

        return new ResponseEntity<ResumesResponse>(new ResumesResponse(new Resume(),HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

    @PostMapping("/resumes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Resume create(@RequestBody Resume resume, @PathVariable Long id){
        User user = userService.findById(id);
        resume.setUser(user);
        return resumeService.save(resume);
    }

    @PostMapping("/resumes")
    @ResponseStatus(HttpStatus.CREATED)
    public Resume update(@RequestBody Resume resume){
        List<Projects> projectsToUpdate = resume.getProjects();
        if(projectsToUpdate.size() > 0){
            projectsToUpdate = projectService.editProjectsFromResumes(projectsToUpdate);
        }
        Resume resumeToUpdate = resumeService.findById(resume.getId());
        resumeToUpdate.setProjects(projectsToUpdate);
        return resumeService.save(resumeToUpdate);
    }

    @DeleteMapping("/resumes/{id}")
    public void delete(@PathVariable Long id){
        resumeService.delete(id);
    }

}
