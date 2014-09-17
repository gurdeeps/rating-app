package com.rateme.beans;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "batchRequest")
public class BatchRequestBean {
    private String userId;

    public String getUserId () {
        return userId;
    }

    public void setUserId (String userId) {
        this.userId = userId;
    }
}
