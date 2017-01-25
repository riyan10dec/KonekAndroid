package model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by riyan on 10/20/16.
 */

public class Category implements Serializable{
    private String categoryName;
    private List<Event> events;

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public List<Event> getEvents() {
        return events;
    }
}
