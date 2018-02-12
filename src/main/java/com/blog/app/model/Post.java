package com.blog.app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid")
    private int pid;
    @Column(name = "name")
    private String name;
    @Column(name = "picture")
    private String picture;
    @Column(name = "preview_text")
    private String preview_text;
    @Column(name = "detail_text")
    private String detail_text;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "updated_at")
    private String updated_at;
    @Column(name = "cid")
    private int cid;
    @Column(name = "user")
    String user;



    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPreview_text() {
        return preview_text;
    }

    public void setPreview_text(String preview_text) {
        this.preview_text = preview_text;
    }

    public String getDetail_text() {
        return detail_text;
    }

    public void setDetail_text(String detail_text) {
        this.detail_text = detail_text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
