package com.rateme.beans;

public class UserRatingBean {
    private String userId;
    private boolean rating;

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    public boolean isRating () {
        return rating;
    }

    public void setRating (boolean rating) {
        this.rating = rating;
    }
}
