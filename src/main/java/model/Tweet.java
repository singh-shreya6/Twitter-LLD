package model;

import java.util.Date;
import java.util.UUID;

public class Tweet {
    UUID id;
    String content;
    TweetMetadata tweetMetadata;
    Date updatedAt;

    public Tweet(UUID id, String content, Date updatedAt) {
        this.id = id;
        this.content = content;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TweetMetadata getTweetMetadata() {
        return tweetMetadata;
    }

    public void setTweetMetadata(TweetMetadata tweetMetadata) {
        this.tweetMetadata = tweetMetadata;
    }

    public static class TweetMetadata {
        long imageId;
        String imageUrl;
        long videoId;
        String videoUrl;
    }
}
