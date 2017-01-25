package model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by riyan on 10/21/16.
 */

public class User implements Serializable{
    private String profilePicture;
    private String name;
    private String gender;
    private List<Category> interest;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Category> getInterest() {
        return interest;
    }

    public void setInterest(List<Category> interest) {
        this.interest = interest;
    }
}
