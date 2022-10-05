package com.example.medicine_project;

public class ListItem {
    int mediId;
    String mediName;

    public ListItem() {
    }

    public ListItem(int mediId, String mediName) {
        this.mediId = mediId;
        this.mediName = mediName;
    }

    public int getMediId() {
        return mediId;
    }

    public void setMediId(int mediId) {
        this.mediId = mediId;
    }

    public String getMediName() {
        return mediName;
    }

    public void setMediName(String mediName) {
        this.mediName = mediName;
    }
}
