package com.rateme.beans;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "myRatingResponse")
public class MyRatingResponseBean {
    private int likes;
    private int disLikes;

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
