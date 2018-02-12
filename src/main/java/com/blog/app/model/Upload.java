package com.blog.app.model;

import javax.persistence.*;

@Entity
@Table(name="upload")
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uploadId")
    private int uploadId;
    @Column(name = "data")
    private String data;

    public int getUploadId() {
        return uploadId;
    }

    public void setUploadId(int uploadId) {
        this.uploadId = uploadId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
