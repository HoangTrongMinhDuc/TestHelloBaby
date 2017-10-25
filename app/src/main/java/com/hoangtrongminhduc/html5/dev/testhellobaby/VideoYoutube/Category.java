package com.hoangtrongminhduc.html5.dev.testhellobaby.VideoYoutube;

/**
 * Created by HTML5 on 25/10/2017.
 */

public class Category {
    private String nameCategory;
    private String idCategory;

    public Category(){

    }

    public Category(String nameCategory, String idCategory) {
        this.nameCategory = nameCategory;
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }
}
