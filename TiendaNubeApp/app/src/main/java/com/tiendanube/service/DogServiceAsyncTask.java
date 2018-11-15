package com.tiendanube.service;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.tiendanube.TiendaNubeApplication;
import com.tiendanube.model.DogModel;
import com.tiendanube.presentation.activity.GenericActivity;
import retrofit2.Response;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DogServiceAsyncTask extends BaseAsyncTask<Void, Void, JsonArray> {

    public DogServiceAsyncTask(Context context) {
        super(context);
    }

    @Override
    protected JsonArray doInBackground(Void... voids) {

        Response<JsonArray> response = null;
        try {
            response = ((GenericActivity) context).application.getServicesAnimals().getDogs().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.body();
    }

    @Override
    protected void onPostExecute(JsonArray jsonElements) {

        super.onPostExecute(jsonElements);
        if(jsonElements != null) {

            String jsonOutput = jsonElements.toString();
            Type listType = new TypeToken<List<DogModel>>() {}.getType();
            List<DogModel> posts = new Gson().fromJson(jsonOutput, listType);
        }

    }
}
