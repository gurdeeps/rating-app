package com.rateme.beans;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "loginResponse")
public class LoginResponseBean {
    private String userId;
    private String name;
    private int likes;
    private int disLikes;

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
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
