package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.dao.ILeadershipDao;
import com.resume.api.ResuMe.entity.Leadership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ILeadershipServiceImpl implements ILeadershipService{

    @Autowired
    ILeadershipDao leadershipDao;

    @Override
    public List<Leadership> findAll() {
        return leadershipDao.findAll();
    }

    @Override
    public Leadership findById(Long id) {
        return leadershipDao.findById(id).orElse(null);
    }

    @Override
    public List<Leadership> findByUserId(Long id) {
        return leadershipDao.findByUserId(id);
    }

    @Override
    public Leadership save(Leadership leadership) {
        return leadershipDao.save(leadership);
    }

    @Override
    public void delete(Long id) {
        leadershipDao.deleteById(id);
    }

    public void deleteResumeLeaderships(Long id){leadershipDao.deleteByLeadershipId(id);}
}
