import controller.TweetController;
import controller.UserController;
import datastore.TweetData;
import datastore.UserData;
import model.Tweet;
import model.User;

import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

/*
Implement an in-memory Twitter (micro-blogging site) with the following assumptions:
The total number of users is ~100
The total number of tweets on Twitter is ~10000
Average follower and following counts are ~7

Provide these functions for Twitter:
A user should be able to post and delete their tweet.
A user should be able to follow and unfollow another user.
View all the info about any user. (bio, image, followers, following, all tweets).
A user should be able to view the feed.
 */
public class Main {

    public static void main(String[] args) throws Exception{

        UserData userData = new UserData();
        TweetData tweetData = new TweetData();

        UserController userController = new UserController(userData);
        TweetController tweetController = new TweetController(userData, tweetData);

        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        UUID uuid3 = UUID.randomUUID();
        UUID uuid4 = UUID.randomUUID();
        User user1 = new User(uuid1, "U1");
        User user2 = new User(uuid2, "U2");
        User user3 = new User(uuid3, "U3");
        User user4 = new User(uuid4, "U4");

        userController.addUser(uuid1, user1);
        userController.addUser(uuid2, user2);
        userController.addUser(uuid3, user3);
        userController.addUser(uuid4, user4);

        userController.follow(uuid1, uuid2);
        userController.follow(uuid1, uuid3);
        userController.follow(uuid3, uuid4);

        UUID tweetID1 = UUID.randomUUID();
        UUID tweetID2 = UUID.randomUUID();
        UUID tweetID3 = UUID.randomUUID();
        UUID tweetID4 = UUID.randomUUID();
        Tweet tweet1 = new Tweet(tweetID1, "First Post", new Date());
        Tweet tweet2 = new Tweet(tweetID2, "Second Post", new Date());
        Tweet tweet3 = new Tweet(tweetID3, "Third Post", new Date());
        Tweet tweet4 = new Tweet(tweetID4, "Fourth Post", new Date());
        tweetController.post(uuid1, tweet1);
        tweetController.post(uuid2, tweet2);
        tweetController.post(uuid3, tweet3);
        tweetController.post(uuid4, tweet4);

        // See Details

        User user = userController.getUserDetails(uuid1);
        printUserDetails(user);


    }

    private static void printUserDetails(User user) {
        System.out.println("User name " + user.toString());
    }
}
