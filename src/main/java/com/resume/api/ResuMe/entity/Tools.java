package com.resume.api.ResuMe.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tools")
public class Tools implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Transient
    private long idUser;

    private long projectId;
    private String name;



    public void setUser(User user) {
        this.user = user;
    }

    public void idUser(long userId) {
        this.idUser = userId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public long getIdUser() {
        return idUser;
    }
}
