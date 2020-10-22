package com.resume.api.ResuMe.entity;

import javax.persistence.*;
import javax.tools.Tool;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="projects")
public class Projects implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @Column(name = "started_date")
    @Temporal(TemporalType.DATE)
    private Date startedDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany
    private List<Tools> tools;

    @ManyToMany
    private List<Resume> resumes;

    @Transient
    private long idUser;

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTools(List<Tools> tools) {
        this.tools = tools;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }


    public void addTool(Tools tool){
        tools.add(tool);
    }



    public List<Tools> getTools() {
        return tools;
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

    public String getDescription() {
        return description;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public long getIdUser() {
        return idUser;
    }

    public List<Resume> getResumes() {
        return resumes;
    }
}
