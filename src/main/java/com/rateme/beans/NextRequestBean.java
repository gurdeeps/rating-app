package com.rateme.beans;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "nextRequest")
public class NextRequestBean {
    private String userId;
    private UserRatingBean userRating;

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }

    public UserRatingBean getUserRating () {
        return userRating;
    }

    public void setUserRating (UserRatingBean userRating) {
        this.userRating = userRating;
    }
}
