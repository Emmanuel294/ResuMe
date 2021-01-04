package com.resume.api.ResuMe.dao;

import com.resume.api.ResuMe.entity.Leadership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ILeadershipDao extends JpaRepository<Leadership,Long> {

    List<Leadership> findByUserId(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM resume_leaderships WHERE leaderships_id = :leadershipId", nativeQuery = true)
    public void deleteByLeadershipId(@Param("leadershipId") Long id);

}
