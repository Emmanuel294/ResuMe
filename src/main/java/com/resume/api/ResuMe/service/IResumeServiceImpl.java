package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.dao.IResumeDao;
import com.resume.api.ResuMe.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IResumeServiceImpl implements IResumeService{

    @Autowired
    private IResumeDao resumeDao;

    @Override
    public List<Resume> findAll() {
        return ((List<Resume>) resumeDao.findAll());
    }

    @Override
    public List<Resume> findAllByUserId(Long id) {
        return resumeDao.findAllByUserId(id);
    }

    @Override
    public Resume findById(Long id) {
        return resumeDao.findById(id).orElse(null);
    }

    @Override
    public Resume save(Resume resume) {
        return resumeDao.save(resume);
    }

    @Override
    public void delete(Long id) {
        resumeDao.deleteById(id);
    }
}
