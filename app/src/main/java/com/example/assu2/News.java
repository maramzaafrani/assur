package com.example.assu2;



public class News {
    private String title;
    private String description;
    private String date;
    private String time;
    private int imageResource;

    public News(String title, String description, String date, String time, int imageResource) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.imageResource = imageResource;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
