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

    List<Projects> saveAll(List<Projects> projects);

    public void delete(Long id);

    void deleteProjectsResumes(Long id);

    List<Projects> editProjectsFromResumes(List<Projects> projects);

}
