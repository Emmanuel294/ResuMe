package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IUserDao extends JpaRepository<User,Long> {

    User findByEmail(String eamil);
}
