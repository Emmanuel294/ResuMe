package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.Leadership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILeadershipDao extends JpaRepository<Leadership,Long> {

    List<Leadership> findByUserId(Long id);

}
