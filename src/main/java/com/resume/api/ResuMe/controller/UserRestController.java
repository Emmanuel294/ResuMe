package com.resume.api.ResuMe.controller;

import com.resume.api.ResuMe.entity.User;
import com.resume.api.ResuMe.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestParam("user") User user){
        return userService.save(user);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User currUser = userService.findById(id);
        currUser.setName(user.getName());
        currUser.setSurname(user.getSurname());
        return userService.save(currUser);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
