package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User,Long> {

}
