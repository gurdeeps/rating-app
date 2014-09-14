package com.rateme.beans;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "nextResponse")
public class NextResponseBean {
    private String matchId;
    private String name;
    private String email;
    private String picture;

    public String getMatchId () {
        return matchId;
    }

    public void setMatchId (String matchId) {
        this.matchId = matchId;
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

    public String getPicture () {
        return picture;
    }

    public void setPicture (String picture) {
        this.picture = picture;
    }
}
