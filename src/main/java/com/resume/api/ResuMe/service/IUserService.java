package com.resume.api.ResuMe.service;

import com.resume.api.ResuMe.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    public List<User> findAll();

    public User findById(Long id);

    User findByEmail(String email);

    public User save(User user);

    public void delete(Long id);
}
