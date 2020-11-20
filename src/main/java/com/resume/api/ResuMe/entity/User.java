package com.resume.api.ResuMe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String picture;

    @Transient
    private String token;


    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Projects> projects;

    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Resume> resumes;

    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tools> tools;

    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Leadership> leaderships;


    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public User() {
        projects = new ArrayList<>();
        resumes = new ArrayList<>();
        tools = new ArrayList<>();
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    public void setTools(List<Tools> tools) {
        this.tools = tools;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setLeaderships(List<Leadership> leaderships) {
        this.leaderships = leaderships;
    }

    public void setToken(String token) {
        this.token = token;
    }



    public void addResume(Resume resume){
        resumes.add(resume);
    }

    public void addProject(Projects project){
        projects.add(project);
    }

    public void addTool(Tools tool){
        tools.add(tool);
    }


    public List<Tools> getTools() {
        return tools;
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPicture() {
        return picture;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public List<Leadership> getLeaderships() {
        return leaderships;
    }

    public String getToken() {
        return token;
    }
}
