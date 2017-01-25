package model;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by riyan on 10/20/16.
 */

public class Event implements Serializable {

    private Image poster;
    private String posterName;
    private int seen;
    private String eventDate;
    private String eventPlace;
    private int shared;
    private int loved;


    private List<String> hashtag;
    private String description;
    private List<User> joinedUser;
    private String longitude;
    private String latitude;

    private String title;
    private String imagePath;

    public String getLongitude() {
        return longitude;
    }


    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public String getPosterName() {
        return posterName;
    }

    public String getEventTitle() {
        return title;
    }

    public void setEventTitle(String eventTitle) {
        this.title = eventTitle;
    }

    public void setPoster(Image poster) {
        this.poster = poster;
    }

    public void setPosterName(String posterName) {
        this.posterName = posterName;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public void setShared(int shared) {
        this.shared = shared;
    }

    public void setLoved(int loved) {
        this.loved = loved;
    }

    public void setHashtag(List<String> hashtag) {
        this.hashtag = hashtag;
    }

    public Image getPoster() {
        return poster;
    }

    public int getSeen() {
        return seen;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public int getShared() {
        return shared;
    }

    public int getLoved() {
        return loved;
    }

    public List<String> getHashtag() {
        return hashtag;
    }

    public List<User> getJoinedUser() {
        return joinedUser;
    }

    public void setJoinedUser(List<User> joinedUser) {
        this.joinedUser = joinedUser;
    }
}

