package com.hoangtrongminhduc.html5.dev.testhellobaby.VideoYoutube;

/**
 * Created by HTML5 on 19/10/2017.
 */

public class Video{
    private String id;
    private String title;
    public Video(){

    }

    public Video(String id, String title) {

        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
