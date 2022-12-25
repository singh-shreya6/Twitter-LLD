package service;

import datastore.TweetData;
import datastore.UserData;
import model.Tweet;
import model.User;

import java.util.List;
import java.util.UUID;


public class TweetService {
    UserData userData;
    TweetData tweetData;

    public TweetService(UserData userData, TweetData tweetData) {
        this.userData = userData;
        this.tweetData = tweetData;
    }

    public void post(UUID userId, Tweet tweet) throws Exception {
        User user = userData.get(userId);
        tweetData.put(tweet.getId(), tweet);
        tweetData.putUserTweets(user, tweet);
        List<UUID> followerIDs = user.getFollowers();
        for (UUID uuid : followerIDs) {
            userData.addToFeed(uuid, tweet);
        }
    }

    public void delete(UUID userId, UUID tweetID) throws Exception {
        User user = userData.get(userId);
        Tweet tweet = tweetData.get(tweetID);
        tweetData.remove(tweetID);
        tweetData.removeTweetFromUser(user, tweetID);
        List<UUID> followerIDs = user.getFollowers();
        for (UUID uuid : followerIDs) {
            userData.removeFromFeed(uuid, tweet);
        }
    }
}
