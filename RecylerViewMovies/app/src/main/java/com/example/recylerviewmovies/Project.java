package com.example.recylerviewmovies;

public class Project {
    private String name;
    private String discription;
    private int image;

    public Project(String name, String discription, int image) {
        this.name = name;
        this.discription = discription;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
