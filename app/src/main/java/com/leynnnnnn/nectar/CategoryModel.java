package com.leynnnnnn.nectar;

public class CategoryModel {
    private int image;
    private String category;

    public CategoryModel(int image, String category) {
        this.image = image;
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
