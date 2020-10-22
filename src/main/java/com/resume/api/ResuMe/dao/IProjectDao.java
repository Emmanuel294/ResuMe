package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.Projects;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IProjectDao extends CrudRepository<Projects,Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM resume_projects WHERE projects_id = :projectId", nativeQuery = true)
    public void deleteByProjectsId(@Param("projectId") Long id);

}
