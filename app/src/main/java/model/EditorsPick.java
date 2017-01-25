package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by riyan on 11/4/16.
 */

public class EditorsPick implements Serializable {
    private String _id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    private String name;
    private Date periodStart;
    private Date periodEnd;
    private ArrayList<Event> events;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public ArrayList<Event> getAllItemsInSection() {
        return events;
    }

    public void setAllItemsInSection(ArrayList<Event> allItemsInSection) {
        this.events = allItemsInSection;
    }
}
