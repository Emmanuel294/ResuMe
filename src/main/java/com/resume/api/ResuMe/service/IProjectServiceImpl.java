package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.dao.IProjectDao;
import com.resume.api.ResuMe.entity.Projects;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IProjectServiceImpl implements IProjectService{

    @Autowired
    private IProjectDao projectDao;

    @Override
    public List<Projects> findAll() {
        return (List<Projects>)projectDao.findAll();
    }

    @Override
    public Projects findById(Long id) {
        return projectDao.findById(id).orElse(null);
    }

    @Override
    public Projects save(Projects project) {
        return projectDao.save(project);
    }

    @Override
    public void delete(Long id) {
        projectDao.deleteById(id);
    }
}
