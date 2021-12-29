package com.samuelmajok.academia.adapter.homeAdapter;

public class featuredHelperClass {

    int image;
    String title, description;

    public featuredHelperClass(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
