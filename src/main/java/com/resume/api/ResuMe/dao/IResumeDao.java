package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IResumeDao extends JpaRepository<Resume,Long> {

    List<Resume> findAllByUserId(@Param("userId") Long id);
}
