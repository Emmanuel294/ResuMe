package com.resume.api.ResuMe.web.responses.Resumes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.resume.api.ResuMe.entity.Resume;
import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.web.responses.BaseResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ResumesResponse extends BaseResponse {

    @JsonProperty("resumes")
    private List<Resume> resumes;

    public ResumesResponse(List<Resume> resumes,Integer statusCode, String message){
        this.resumes = resumes;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResumesResponse(Resume resume,Integer statusCode, String message){
        this.resumes = new ArrayList<Resume>();
        this.resumes.add(resume);
        this.statusCode = statusCode;
        this.message = message;
    }
}
