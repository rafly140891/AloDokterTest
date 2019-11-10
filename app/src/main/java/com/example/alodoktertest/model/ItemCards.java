package com.example.alodoktertest.model;

public class ItemCards {

    private String typeImage;
    private String titleImage;
    private int imageSource;

    public ItemCards(String typeImage, String titleImage, int imageSource) {
        this.typeImage = typeImage;
        this.titleImage = titleImage;
        this.imageSource = imageSource;
    }

    public String getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public int getImageSource() {
        return imageSource;
    }

    public void setImageSource(int imageSource) {
        this.imageSource = imageSource;
    }
}
