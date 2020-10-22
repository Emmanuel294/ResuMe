package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.Tools;
import com.resume.api.ResuMe.service.IProjectServiceImpl;
import com.resume.api.ResuMe.service.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectsRestController {

    @Autowired
    private IProjectServiceImpl projectService;

    @Autowired
    private IUserServiceImpl userService;



    @GetMapping("/projects")
    public List<Projects> tools(){
        return projectService.findAll();
    }

    @GetMapping("/projects/{id}")
    public Projects tools(@PathVariable Long id){
        return projectService.findById(id);
    }

    @PostMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public Projects create(@RequestBody Projects project){
        project.setUser(userService.findById(project.getIdUser()));
        return projectService.save(project);
    }

    @PutMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Projects update(@PathVariable Long id, @RequestBody Projects project){
        Projects current = projectService.findById(id);
        if(current != null){
            if(project.getName() != null){
                current.setName(project.getName());
            }
            if(project.getDescription() != null){
                current.setDescription(project.getDescription());
            }
            if(project.getTools() != null){
                current.setTools(project.getTools());
            }
            if(project.getStartedDate() != null){
                current.setStartedDate(project.getStartedDate());
            }
            if(project.getEndDate() != null){
                current.setEndDate(project.getEndDate());
            }
        }

        return projectService.save(current);
    }

    @DeleteMapping("/projects/{id}")
    public void delete(@PathVariable Long id){
        Projects project = projectService.findById(id);
        project.getTools().removeAll(project.getTools());
        project.getResumes().removeAll(project.getResumes());
        projectService.save(project);
        projectService.delete(id);
    }
}
