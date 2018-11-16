package com.tiendanube.api;

import com.google.gson.JsonArray;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("images/search?size=med&mime_types=jpg&format=json&has_breeds=true&order=RANDOM&limit=25")
    Call<JsonArray> getDogs(@Query("page") int page);
}


