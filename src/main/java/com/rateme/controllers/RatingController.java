package com.rateme.controllers;

import com.rateme.beans.LoginRequestBean;
import com.rateme.beans.LoginResponseBean;
import com.rateme.beans.MyRatingRequestBean;
import com.rateme.beans.MyRatingResponseBean;
import com.rateme.beans.NextRequestBean;
import com.rateme.beans.NextResponseBean;
import com.rateme.beans.SubmitRatingRequestBean;
import com.rateme.beans.SubmitRatingResponseBean;
import com.rateme.beans.UserRatingBean;
import com.rateme.dao.UserDAO;
import com.rateme.domain.UserRating;
import com.rateme.search.SearchService;
import com.rateme.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;


@Controller
public class RatingController {
    @Autowired
    SearchService searchService;
    HashMap<String, List<User>> userMatches = new HashMap<String, List<User>>();

    HashMap<String, Integer> matchCounters = new HashMap<String, Integer>();

    @Autowired
    UserDAO userDAO;

    @PostConstruct
    void init() {
        userDAO.init();
    }

    @ResponseBody
    @RequestMapping("/login")
    public LoginResponseBean login(@RequestBody LoginRequestBean request) {
        LoginResponseBean response = new LoginResponseBean();
        User user = userDAO.getUserByEmail(request.getEmail());
        response.setUserId(user.getId());
        response.setName(user.getName());
        response.setLikes(user.getLikes());
        response.setDisLikes(user.getDisLikes());
        return response;
    }

    @ResponseBody
    @RequestMapping("/next")
    public NextResponseBean next(@RequestBody NextRequestBean nextRequest) {
        UserRatingBean userRating = nextRequest.getUserRating();
        if(userRating != null) {
            if(userRating.isRating()) {
                userDAO.addLike(userRating.getUserId());
            } else {
                userDAO.addDisLike(userRating.getUserId());
            }
        }
        NextResponseBean next = new NextResponseBean();
        List<User> matches = userMatches.get(nextRequest.getUserId());
        if(matches == null) {
            matches = searchService.getMatches(nextRequest.getUserId());
        }
        User match = null;
        if(matches != null && matches.size() > 0) {
            Integer matchCounter = matchCounters.get(nextRequest.getUserId());
            if(matchCounter == null) {
                match = matches.get(0);
                matchCounters.put(nextRequest.getUserId(), 0);
            } else {
                matchCounter++;
                match = matches.get(matchCounter);
                matchCounters.put(nextRequest.getUserId(), matchCounter);
            }

            next.setMatchId(match.getId());
            next.setName(match.getName());
            next.setEmail(match.getEmail());
            next.setPicture(match.getImage());
        }
        return next;
    }

    @ResponseBody
    @RequestMapping("/myRating")
    public MyRatingResponseBean myRating(@RequestBody MyRatingRequestBean myRatingRequest) {
        MyRatingResponseBean responseBean = new MyRatingResponseBean();
        UserRating rating = userDAO.getUserRating(myRatingRequest.getUserId());
        responseBean.setLikes(rating.getLikes());
        responseBean.setDisLikes(rating.getDisLikes());
        return responseBean;
    }

    @ResponseBody
    @RequestMapping("/submitRating")
    public SubmitRatingResponseBean submitRating(@RequestBody SubmitRatingRequestBean submitRatingRequest) {
        SubmitRatingResponseBean responseBean = new SubmitRatingResponseBean();
        UserRatingBean userRating = submitRatingRequest.getUserRating();
        if(userRating != null) {
            if(userRating.isRating()) {
                userDAO.addLike(userRating.getUserId());
            } else {
                userDAO.addDisLike(userRating.getUserId());
            }
            responseBean.setSuccess(true);
        }
        return responseBean;
    }
}
