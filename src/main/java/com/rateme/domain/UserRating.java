package com.rateme.domain;

public class UserRating {
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
