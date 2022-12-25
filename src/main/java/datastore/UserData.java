package datastore;

import model.Tweet;
import model.User;

import java.util.*;

public class UserData {

    Map<UUID, User> users;
    Map<UUID, List<Tweet>> userFeed;

    public UserData() {
        this.users = new HashMap<>();
        this.userFeed = new HashMap<>();
    }

    public void add(UUID userID, User user) {
        users.put(userID, user);
    }

    public User get(UUID userID) throws Exception {
        if (!users.containsKey(userID)) {
            throw new Exception("User doesn't exist");
        }
        return users.get(userID);
    }

    public void addToFeed(UUID userID, Tweet tweet) throws Exception {
        if (!users.containsKey(userID)) {
            throw new Exception("User doesn't exist");
        }
        if (!userFeed.containsKey(userID)) {
            userFeed.put(userID, new ArrayList<Tweet>(Arrays.asList(tweet)));
        } else {
            userFeed.get(userID).add(tweet);
        }
    }

    public void removeFromFeed(UUID userID, Tweet tweet) throws Exception {
        if (!users.containsKey(userID)) {
            throw new Exception("User doesn't exist");
        }
        if (userFeed.containsKey(userID)) {
            userFeed.get(userID).remove(tweet);
        }
    }

    public List<Tweet> getFeed(UUID userID) throws Exception {
        if (!users.containsKey(userID)) {
            throw new Exception("User doesn't exist");
        }
        if (!userFeed.containsKey(userID)) {
            throw new Exception("User doesn't exist");
        }
        return userFeed.get(userID);
    }
}
