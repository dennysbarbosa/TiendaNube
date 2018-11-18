package com.tiendanube.model;

import com.google.gson.annotations.SerializedName;

public class CatModel {

    @SerializedName("id")
    public String id;

    @SerializedName("url")
    public String imageUrl;

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
