package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.Tools;
import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.service.IProjectService;
import com.resume.api.ResuMe.service.IProjectServiceImpl;
import com.resume.api.ResuMe.service.IUserService;
import com.resume.api.ResuMe.service.IUserServiceImpl;
import com.resume.api.ResuMe.web.responses.Projects.ProjectsResponse;
import com.resume.api.ResuMe.web.responses.Tools.ToolsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectsRestController {

    @Autowired
    private IProjectServiceImpl projectService;

    @Autowired
    private IUserService userService;



    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectsResponse> projectsByUser(@PathVariable Long id){
        List<Projects> projects = projectService.findAllByUserId(id);
        if(projects != null && projects.size() > 0){
            return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(projects,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }
        return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(projects,HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

    @GetMapping("/projects/{id}/{pid}")
    public ResponseEntity<ProjectsResponse> projects(@PathVariable Long id,@PathVariable Long pid){
        Projects project = projectService.findById(pid);
        if(project != null && project.getUser().getId() == id){
            return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(project,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }
        return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(new Projects(),HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

    @PostMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProjectsResponse>  create(@PathVariable Long id,@RequestBody Projects project){
        project.setUser(userService.findById(id));
        Projects createdProject = projectService.save(project);
        if(createdProject != null){
            return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(createdProject,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }
        return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(project,HttpStatus.OK.value(),"no content"),HttpStatus.OK);
    }

    @PutMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProjectsResponse> update(@PathVariable Long id, @RequestBody Projects project){
        Projects current = projectService.findById(project.getId());
        if(current != null && current.getUser().getId() == id){
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

            project =  projectService.save(current);
            return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(project,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }

        return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(project,HttpStatus.OK.value(),"This project is not yours"),HttpStatus.OK);

    }

    @DeleteMapping("/projects/{id}/{pid}")
    public ResponseEntity<ProjectsResponse> delete(@PathVariable Long id, @PathVariable Long pid){
        Projects project = projectService.findById(pid);
        if(project != null && project.getUser().getId() == id){
            project.getTools().removeAll(project.getTools());
            projectService.deleteProjectsResumes(pid);
            projectService.save(project);
            projectService.delete(pid);
            return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(project,HttpStatus.OK.value(),"success"),HttpStatus.OK);
        }
        return new ResponseEntity<ProjectsResponse>(new ProjectsResponse(project,HttpStatus.OK.value(),"This project is not yours"),HttpStatus.OK);

    }
}
