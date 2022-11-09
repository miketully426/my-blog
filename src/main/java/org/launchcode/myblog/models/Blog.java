package org.launchcode.myblog.models;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class Blog {

    private int id;
    private static int nextId = 1;

    @NotBlank(message="Must have a title!")
    private String title;
    private String content;
    private LocalDate date;
    private Status status;

    public Blog() {
        this.id = nextId;
        nextId++;
    }

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
}
