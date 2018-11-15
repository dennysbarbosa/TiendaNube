package com.tiendanube.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogModel {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("temperament")
    public String temperament;

    @SerializedName("url")
    public String imageUrl;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
