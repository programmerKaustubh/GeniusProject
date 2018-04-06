package com.kmema.android.geniusproject.model;

public class UpdateUser {
    private String name;

    private String job;

    public UpdateUser(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getJob ()
    {
        return job;
    }

    public void setJob (String job)
    {
        this.job = job;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", job = "+job+"]";
    }
}
