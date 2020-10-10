package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.dao.IToolsDao;
import com.resume.api.ResuMe.entity.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IToolsServiceImpl implements IToolsService{

    @Autowired
    private IToolsDao iToolsDao;

    @Override
    public List<Tools> findAll() {
        return (List<Tools>) iToolsDao.findAll();
    }

    @Override
    public Tools findById(Long id) {
        return iToolsDao.findById(id).orElse(null);
    }

    @Override
    public Tools save(Tools tool) {
        return iToolsDao.save(tool);
    }

    @Override
    public void delete(Long id) {
        iToolsDao.deleteById(id);
    }
}
