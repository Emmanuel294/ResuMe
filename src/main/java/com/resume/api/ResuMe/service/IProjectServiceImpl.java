package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.dao.IProjectDao;
import com.resume.api.ResuMe.dao.IToolsDao;
import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IProjectServiceImpl implements IProjectService{

    @Autowired
    private IProjectDao projectDao;

    @Autowired
    private IToolsServiceImpl toolsService;

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
    public List<Projects> saveAll(List<Projects> projects) {
        return  projectDao.saveAll(projects);
    }

    @Override
    public void delete(Long id) {
        projectDao.deleteById(id);
    }

    @Override
    public void deleteProjectsResumes(Long id) {
        projectDao.deleteByProjectsId(id);
    }

    @Override
    public List<Projects> editProjectsFromResumes(List<Projects> projects) {
        List<Projects> projectsToUpdate = new ArrayList<>();

        for(Projects project: projects){
            Projects projectToUpdate = projectDao.findById(project.getId()).orElse(null);
            if(projectToUpdate != null){
                if(project.getName() != null && !project.getName().isEmpty()){
                    projectToUpdate.setName(project.getName());
                }
                if(project.getDescription() != null && !project.getDescription().isEmpty()){
                    projectToUpdate.setDescription(project.getDescription());
                }
                if(project.getStartedDate() != null){
                    projectToUpdate.setStartedDate(project.getStartedDate());
                }
                if(project.getEndDate() != null){
                    projectToUpdate.setEndDate(project.getEndDate());
                }
                if(project.getTools() != null && project.getTools().size() > 0){
                    List<Tools> toolsUpdated = toolsService.updateToolsFromResume(project.getTools());
                    projectToUpdate.setTools(toolsUpdated);
                }
            }

            projectsToUpdate.add(projectToUpdate);
        }

        return projectDao.saveAll(projectsToUpdate);
    }

    public List<Projects> findAllByUserId(Long id) {
        return projectDao.findAllByUserId(id);
    }
}
