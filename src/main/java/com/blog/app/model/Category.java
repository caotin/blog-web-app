package com.blog.app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cid")
    private int cid;
    @Column(name="name")
    private String name;
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date create_at;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_at() {
        return create_at;
    }
    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
}
