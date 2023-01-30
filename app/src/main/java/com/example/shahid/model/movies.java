package com.example.shahid.model;

public class movies {

    public String name_movie ;
    public int img_movie ;
    public int id_item ;


    public movies() {
    }

    public movies(String name_movie, int img_movie , int id_item) {
        this.name_movie = name_movie;
        this.img_movie = img_movie;
        this.id_item  =id_item ;
    }

    public String getName_movie() {
        return name_movie;
    }

    public void setName_movie(String name_movie) {
        this.name_movie = name_movie;
    }

    public int getImg_movie() {
        return img_movie;
    }

    public void setImg_movie(int img_movie) {
        this.img_movie = img_movie;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }
}
