package com.rateme.domain;


public class User {
    
    
    private String id;
    private String managerId;
    private String name;

    private int likes;
    private int disLikes;
    
    private String email;
    
    private String image;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getManagerId () {
        return managerId;
    }

    public void setManagerId (String managerId) {
        this.managerId = managerId;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getImage () {
        return image;
    }

    public void setImage (String image) {
        this.image = image;
    }

    public int getLikes () {
        return likes;
    }

    public void setLikes (int likes) {
        this.likes = likes;
    }

    public int getDisLikes () {
        return disLikes;
    }

    public void setDisLikes (int disLikes) {
        this.disLikes = disLikes;
    }
}
