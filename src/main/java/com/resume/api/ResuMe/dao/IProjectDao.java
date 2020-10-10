package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.Projects;
import org.springframework.data.repository.CrudRepository;

public interface IProjectDao extends CrudRepository<Projects,Long> {

}
