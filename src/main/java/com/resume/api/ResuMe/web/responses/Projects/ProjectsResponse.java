package com.resume.api.ResuMe.web.responses.Projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.Tools;
import com.resume.api.ResuMe.web.responses.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class ProjectsResponse extends BaseResponse {

    @JsonProperty("projects")
    private List<Projects> projectsList;

    public ProjectsResponse(List<Projects> projects,Integer statusCode, String message){
        this.projectsList = projects;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ProjectsResponse(Projects project,Integer statusCode, String message){
        projectsList = new ArrayList<>();
        this.projectsList.add(project);
        this.statusCode = statusCode;
        this.message = message;
    }
}
