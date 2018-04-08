package com.kmema.android.geniusproject.model;

import android.os.Parcel;

public class UpdatedUserData extends UniversalData {
    private String id;

    private String createdAt;

    private String name;

    private String job;

    protected UpdatedUserData(Parcel in) {
        super(in);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", createdAt = " + createdAt + ", name = " + name + ", job = " + job + "]";
    }
}
