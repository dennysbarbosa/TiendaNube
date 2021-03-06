package com.tiendanube.service;


import android.support.v4.app.Fragment;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.tiendanube.TiendaNubeApplication;
import com.tiendanube.model.DogModel;
import com.tiendanube.presentation.activity.HomeActivity;
import com.tiendanube.presentation.fragment.DogFragment;
import retrofit2.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class DogServiceAsyncTask extends BaseAsyncTask<Void, Void, JsonArray> {

    private int page;
    DogFragment dogFragment;

    public DogServiceAsyncTask(Fragment fragment, int page) {

        super(fragment);
        this.page = page;
        dogFragment = (DogFragment) fragment;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dogFragment.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected JsonArray doInBackground(Void... voids) {

        Response<JsonArray> response = null;
        try {
            response = ((HomeActivity) dogFragment.getActivity()).application.getServicesAnimals(TiendaNubeApplication.TYPE_DOG).getDogs(page).execute();
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
            dogFragment.progressBar.setVisibility(View.GONE);
            dogFragment.processFinish(new Gson().fromJson(jsonOutput, listType));
        }

    }
}
