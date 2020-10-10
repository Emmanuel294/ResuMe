package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.entity.Tools;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IToolsService {

    public List<Tools> findAll();

    public Tools findById(Long id);

    public Tools save(Tools tool);

    public void delete(Long id);
}