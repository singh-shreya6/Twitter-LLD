package controller;

import datastore.UserData;
import model.Tweet;
import model.User;
import service.UserService;

import java.util.List;
import java.util.UUID;

public class UserController {

    UserService userService;

    public UserController(UserData userData) {
        this.userService = new UserService(userData);
    }

    public void addUser(UUID userID, User user) throws Exception  {
        try {
            userService.addUser(userID, user);
        } catch (Exception e) {
            System.out.println("Unable to add!!");
            throw e;
        }
    }

    public void follow(UUID userID, UUID toFollowId) throws Exception {
        try {
            userService.follow(userID, toFollowId);
        } catch (Exception e) {
            System.out.println("Unable to follow!!");
            throw e;
        }
    }

    public void unfollow(UUID userID, UUID userToUnfollowId) throws Exception {
        try {
            userService.unfollow(userID, userToUnfollowId);
        } catch (Exception e) {
            System.out.println("Failed to unfollow!! Please try again");
            throw e;
        }
    }

    public User getUserDetails(UUID userID) throws Exception {
        try {
            return userService.get(userID);
        } catch (Exception e) {
            System.out.println("No User found");
            throw e;
        }
    }

    public List<Tweet> getUserFeed(UUID userID, int offset, int limit) throws Exception {
        try {
            return userService.getUserFeed(userID, offset, limit);
        } catch (Exception e) {
            System.out.println("Unable to generate Feed");
            throw e;
        }
    }
}
