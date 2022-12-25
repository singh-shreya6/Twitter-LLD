package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    UUID id;
    String name;
    List<UUID> followers;
    List<UUID> following;
    List<UUID> tweetIds;
    String bio;

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.tweetIds = new ArrayList<>();
    }

    public List<UUID> getTweetIds() {
        return tweetIds;
    }

    public void setTweetIds(List<UUID> tweetIds) {
        this.tweetIds = tweetIds;
    }


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<UUID> getFollowers() {
        return followers;
    }

    public List<UUID> getFollowing() {
        return following;
    }

    public String getBio() {
        return bio;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFollowers(List<UUID> followers) {
        this.followers = followers;
    }

    public void setFollowing(List<UUID> following) {
        this.following = following;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", followers=" + followers +
                ", following=" + following +
                ", tweetIds=" + tweetIds +
                ", bio='" + bio + '\'' +
                '}';
    }
}
