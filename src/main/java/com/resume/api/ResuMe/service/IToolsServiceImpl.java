package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.dao.IToolsDao;
import com.resume.api.ResuMe.entity.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    public List<Tools> saveAll(List<Tools> tools) {
        return iToolsDao.saveAll(tools);
    }

    @Override
    public void delete(Long id) {
        iToolsDao.deleteById(id);
    }

    @Override
    public List<Tools> updateToolsFromResume(List<Tools> tools) {
        List<Tools> newToolsList = new ArrayList<>();
        for(Tools tool: tools){
            Tools toolToUpdate = iToolsDao.findById(tool.getId()).orElse(null);

            if(toolToUpdate != null){
                if(tool.getName() != null && !tool.getName().isEmpty()){
                    toolToUpdate.setName(tool.getName());
                }
            }
            newToolsList.add(toolToUpdate);
        }

        return iToolsDao.saveAll(newToolsList);
    }
}
