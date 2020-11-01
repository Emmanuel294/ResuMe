package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.entity.Leadership;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILeadershipService {

    List<Leadership> findAll();

    Leadership findById(Long id);

    List<Leadership> findByUserId(Long id);

    Leadership save(Leadership leadership);

    void delete(Long id);
}
