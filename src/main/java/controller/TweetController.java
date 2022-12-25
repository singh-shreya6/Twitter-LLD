package controller;

import datastore.TweetData;
import datastore.UserData;
import model.Tweet;
import service.TweetService;

import java.util.UUID;

public class TweetController {
    public TweetService tweetService;

    public TweetController(UserData userData, TweetData tweetData) {
        this.tweetService = new TweetService(userData, tweetData);
    }

    public void post(UUID userId, Tweet tweet) throws Exception {
        try {
            tweetService.post(userId, tweet);
        } catch (Exception e) {
            System.out.println("Unable to post tweet!!");
            throw e;
        }
    }

    public void delete(UUID userId, UUID tweetId) throws Exception {
        try {
            tweetService.delete(userId, tweetId);
        } catch (Exception e) {
            System.out.println("Unable to delete tweet!!");
            throw e;
        }
    }
}
