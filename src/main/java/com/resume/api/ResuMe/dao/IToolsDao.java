package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.Resume;
import com.resume.api.ResuMe.entity.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IToolsDao extends JpaRepository<Tools, Long> {

    List<Tools> findAllByUserId(@Param("userId") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM projects_tools WHERE tools_id = :toolsId", nativeQuery = true)
    void deleteByToolId(@Param("toolsId") Long id);
}
