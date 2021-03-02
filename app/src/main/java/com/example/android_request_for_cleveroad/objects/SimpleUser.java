package com.example.android_request_for_cleveroad.objects;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SimpleUser {


    private String title;
    private String first;
    private String last;
    private String picture;

    @PrimaryKey(autoGenerate = true)
    private long id;


    public SimpleUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }




    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String setFullName(String fullName) {
        return  fullName;
    }

    public String getFullName() {
        return  title + " " +
                 first +  " " + last +  " " ;

    }
}
