package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IToolsDao extends JpaRepository<Tools, Long> {
}
