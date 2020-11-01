package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.entity.Resume;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IResumeService {

    List<Resume> findAll();

    List<Resume> findAllByUserId(Long userId);

    Resume findById(Long id);

    Resume save(Resume resume);

    void delete(Long id);
}
