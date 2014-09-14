package com.rateme.beans;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "myRatingRequest")
public class MyRatingRequestBean {
    private String userId;

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }
}
