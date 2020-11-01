package com.resume.api.ResuMe.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="leadership")
public class Leadership implements Serializable {

    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String description;

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
