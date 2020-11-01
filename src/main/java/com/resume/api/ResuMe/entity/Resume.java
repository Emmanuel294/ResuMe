package com.resume.api.ResuMe.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="resume")
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany
    private List<Projects> projects;

    public void setId(long id) {
        this.id = id;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }


    public long getId() {
        return id;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
