package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.Tools;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProjectService {

    public List<Projects> findAll();

    public Projects findById(Long id);

    public Projects save(Projects project);

    public void delete(Long id);

}
