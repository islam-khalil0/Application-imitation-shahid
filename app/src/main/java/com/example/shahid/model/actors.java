package com.example.shahid.model;

public class actors {

   public String name_actor ;
   public int image_actor ;

    public actors() {
    }

    public actors(String name_actor, int image_actor) {
        this.name_actor = name_actor;
        this.image_actor = image_actor;
    }

    public String getName_actor() {
        return name_actor;
    }

    public void setName_actor(String name_actor) {
        this.name_actor = name_actor;
    }

    public int getImage_actor() {
        return image_actor;
    }

    public void setImage_actor(int image_actor) {
        this.image_actor = image_actor;
    }
}
