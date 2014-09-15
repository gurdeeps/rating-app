package com.rateme.beans;

public class SubmitRatingRequestBean {
    private String userId;
    private UserRatingBean userRating;

    public UserRatingBean getUserRating () {
        return userRating;
    }

    public void setUserRating (UserRatingBean userRating) {
        this.userRating = userRating;
    }

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }
}
