package com.tiendanube.model;

import com.google.gson.annotations.SerializedName;

public class BreedModel {

    @SerializedName("name")
    public String name;

    @SerializedName("temperament")
    public String temperament;

    public String getName() {
        return name;
    }

    public String getTemperament() {
        return temperament;
    }
}
