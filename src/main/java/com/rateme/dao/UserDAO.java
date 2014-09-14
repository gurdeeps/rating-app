package com.rateme.dao;

import com.rateme.domain.User;
import com.rateme.domain.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class UserDAO {

    @Autowired
    private DataSource datasource;

    private HashMap<String, User> userIdUserMap = new HashMap<String, User>();
    private HashMap<String, User> emailUserMap = new HashMap<String, User>();
    private List<User> users = new ArrayList<User>();

    public void init() {
        Connection con = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            con = datasource.getConnection();
            statement = con.createStatement();
            rs = statement.executeQuery("SELECT * FROM dc_rating.user");
            while (rs.next()) {
                String userId = trim(rs.getString("userId"));
                String name = trim(rs.getString("name"));
                String email = trim(rs.getString("email"));
                String image = trim(rs.getString("imageId"));
                String managerId = trim(rs.getString("managerId"));


                User user = new User();
                user.setId(userId);
                user.setName(name);
                user.setEmail(email);
                user.setImage(image);
                user.setManagerId(managerId);

                if(emailUserMap.get(email) == null) {
                    userIdUserMap.put(userId, user);
                    emailUserMap.put(email, user);
                    users.add(user);
                }

            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(statement);
            close(con);
        }
    }

    public int getCount() {
        return users.size();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(String id) {
        return userIdUserMap.get(id);
    }

    public User getUserByEmail(String email) {
        return emailUserMap.get(email);
    }

    public void addLike(String userId) {
        User user = userIdUserMap.get(userId);
        if(user != null) {
            user.setLikes(user.getLikes() + 1);
        }
    }

    public void addDisLike(String userId) {
        User user = userIdUserMap.get(userId);
        if(user != null) {
            user.setDisLikes(user.getDisLikes() + 1);
        }
    }

    public UserRating getUserRating(String userId) {
        User user = userIdUserMap.get(userId);
        if(user != null) {
            UserRating rating = new UserRating();
            rating.setLikes(user.getLikes());
            rating.setDisLikes(user.getDisLikes());
            return rating;
        }
        return null;
    }

    void close(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (Exception e) {}
        }
    }

    void close(Statement statement) {
        if(statement != null) {
            try {
                statement.close();
            } catch (Exception e) {}
        }
    }

    void close(ResultSet result) {
        if(result != null) {
            try {
                result.close();
            } catch (Exception e) {}
        }
    }

    String trim(String input) {
        if(input != null) {
            return input.trim();
        }
        return input;
    }

}
