package service;

import datastore.UserData;
import model.Tweet;
import model.User;

import java.util.List;
import java.util.UUID;

public class UserService {

    UserData userData;

    public UserService(UserData userData) {
        this.userData = userData;
    }

    public User get(UUID userID) throws Exception {
        return userData.get(userID);
    }

    public void addUser(UUID userID, User user) throws Exception {
        userData.add(userID, user);
    }

    public void follow(UUID userID, UUID toFollowID) throws Exception {
        User user = get(userID);
        User toFollowUser = get(toFollowID);

        user.getFollowing().add(toFollowID);
        toFollowUser.getFollowers().add(userID);
    }

    public void unfollow(UUID userID, UUID toUnfollowID) throws Exception {
        User user = get(userID);
        User toFollowUser = get(toUnfollowID);

        user.getFollowing().remove(toUnfollowID);
        toFollowUser.getFollowers().remove(userID);
    }

    public List<Tweet> getUserFeed(UUID userID, int offset, int limit) throws Exception {
        // Set offset
        return userData.getFeed(userID);
    }
}
