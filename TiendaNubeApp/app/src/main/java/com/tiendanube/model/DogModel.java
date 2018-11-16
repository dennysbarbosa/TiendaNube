package com.tiendanube.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogModel {

    @SerializedName("id")
    public String id;

    @SerializedName("url")
    public String imageUrl;

    @SerializedName("breeds")
    List<BreedModel> listBreesds;

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<BreedModel> getListBreesds() {
        return listBreesds;
    }
}
