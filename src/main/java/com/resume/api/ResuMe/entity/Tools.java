package com.resume.api.ResuMe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tools")
public class Tools implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter
    @Setter
    @JsonIgnore
    private User user;

    @Transient
    private long idUser;

    private String name;



    public void setUser(User user) {
        this.user = user;
    }

    public void idUser(long userId) {
        this.idUser = userId;
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


    public String getName() {
        return name;
    }

    public long getIdUser() {
        return idUser;
    }
}
