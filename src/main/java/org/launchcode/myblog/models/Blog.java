package org.launchcode.myblog.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message="Must have a title!")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDate date;
    private Status status;

    @ManyToOne
    @NotNull(message="You must select a user!")
    private User user;

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId(){
        return id;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
