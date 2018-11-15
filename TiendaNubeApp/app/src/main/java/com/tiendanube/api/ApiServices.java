package com.tiendanube.api;

import com.google.gson.JsonArray;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("images/search?size=med&mime_types=jpg&format=json&has_breeds=true&order=RANDOM&page=0&limit=10")
    Call<JsonArray> getDogs();
}


