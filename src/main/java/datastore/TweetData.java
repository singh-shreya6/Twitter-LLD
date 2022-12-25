package datastore;

import model.Tweet;
import model.User;

import java.util.*;

public class TweetData {

    Map<UUID, Tweet> tweets;

    public TweetData() {
        this.tweets = new HashMap<>();
    }

    public Tweet get(UUID id) throws Exception {
        if (!tweets.containsKey(id)) {
            throw new Exception("Tweet doesn't exist");
        }
        return tweets.get(id);
    }

    public void put(UUID id, Tweet tweet) {
        tweets.put(id, tweet);
    }

    public void remove(UUID id) {
        tweets.remove(id);
    }

    public void removeTweetFromUser(User user, UUID tweetId) throws Exception {
        if (!user.getTweetIds().contains(tweetId)) {
            throw new Exception("Tweet does not belong to user");
        }
        user.getTweetIds().remove(tweetId);
        tweets.remove(tweetId);
    }

    public List<Tweet> getTweetsByUser(User user) throws Exception {
        List<UUID> tweetIds = user.getTweetIds();
        List<Tweet> userTweets = new ArrayList<>();
        for (UUID tweetId: tweetIds) {
            userTweets.add(tweets.get(tweetId));
        }
        return userTweets;
    }

    public void putUserTweets(User user, Tweet tweet) throws Exception {
        user.getTweetIds().add(tweet.getId());
        tweets.put(tweet.getId(), tweet);
    }
}
