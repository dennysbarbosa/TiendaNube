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
import com.tiendanube.presentation.activity.HomeActivity;
import com.tiendanube.presentation.fragment.DogFragment;
import retrofit2.Response;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DogServiceAsyncTask extends BaseAsyncTask<Void, Void, JsonArray> {

    private HomeActivity homeActivity;
    private int page;

    public DogServiceAsyncTask(Context context, int page) {

        super(context);
        this.homeActivity = ((HomeActivity) context);
        this.page = page;
    }

    @Override
    protected JsonArray doInBackground(Void... voids) {

        Response<JsonArray> response = null;
        try {
            response = homeActivity.application.getServicesAnimals().getDogs(page).execute();
        } catch (IOException e) {
            e.printStackTrace();
            cancel(true);
        }
        return response.body() != null ? response.body(): null;
    }

    @Override
    protected void onPostExecute(JsonArray jsonElements) {

        super.onPostExecute(jsonElements);
        if(jsonElements != null) {

            String jsonOutput = jsonElements.toString();
            Type listType = new TypeToken<List<DogModel>>() {}.getType();
            DogFragment dogFragment = (DogFragment) homeActivity.animalsFragmentAdapter.getItem(0);
            dogFragment.processFinish(new Gson().fromJson(jsonOutput, listType));
        }

    }
}
