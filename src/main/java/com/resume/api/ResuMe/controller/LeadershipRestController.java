package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.Leadership;
import com.resume.api.ResuMe.entity.Projects;
import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.service.ILeadershipServiceImpl;
import com.resume.api.ResuMe.service.IUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LeadershipRestController {

    @Autowired
    ILeadershipServiceImpl leadershipService;

    @Autowired
    IUserServiceImpl userService;

    @GetMapping("/leadership")
    public List<Leadership> leadership(){
        return leadershipService.findAll();
    }

    @GetMapping("/leadership/user/{id}")
    public List<Leadership> findByUserId(@PathVariable Long id){
        return leadershipService.findByUserId(id);
    }

    @GetMapping("/leadership/{id}")
    public Leadership leadership(@PathVariable Long id){
        return leadershipService.findById(id);
    }

    @PostMapping("/leadership/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Leadership create(@PathVariable Long id, @RequestBody Leadership leadership){
        User user = userService.findById(id);
        leadership.setUser(user);
        return leadershipService.save(leadership);
    }

    @PutMapping("/leadership/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Leadership update(@PathVariable Long id, @RequestBody Leadership leadership){
        Leadership current = leadershipService.findById(id);
        if(leadership.getDate() != null){
            current.setDate(leadership.getDate());
        }
        if(leadership.getDescription() != null){
            current.setDescription(leadership.getDescription());
        }

        return leadershipService.save(current);
    }

    @DeleteMapping("/leadership/{id}")
    public void delete(@PathVariable Long id){
        leadershipService.deleteResumeLeaderships(id);
        leadershipService.delete(id);
    }
}
