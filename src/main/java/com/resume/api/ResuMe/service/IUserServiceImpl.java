package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.dao.IUserDao;
import com.resume.api.ResuMe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
