package com.tiendanube.service;

import android.support.v4.app.Fragment;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.tiendanube.TiendaNubeApplication;
import com.tiendanube.model.CatModel;
import com.tiendanube.presentation.activity.HomeActivity;
import com.tiendanube.presentation.fragment.CatFragment;
import retrofit2.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CatServiceAsyncTask extends BaseAsyncTask<Void, Void, JsonArray> {

    private CatFragment catFragment;

    public CatServiceAsyncTask(Fragment fragment) {
        super(fragment);
        this.catFragment = (CatFragment) fragment;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        catFragment.progressBarCat.setVisibility(View.VISIBLE);
    }

    @Override
    protected JsonArray doInBackground(Void... voids) {

        Response<JsonArray> response = null;

        try {
            response = ((HomeActivity) catFragment.getActivity()).application.getServicesAnimals(TiendaNubeApplication.TYPE_CAT).getCats().execute();
        } catch (IOException e) {
            e.printStackTrace();
            cancel(true);
        }
        return response.body() != null ? response.body() : null;
    }

    @Override
    protected void onPostExecute(JsonArray jsonElements) {
        super.onPostExecute(jsonElements);

        catFragment.progressBarCat.setVisibility(View.GONE);
        if (jsonElements != null){

            String jsonOutput = jsonElements.toString();
            Type listType = new TypeToken<List<CatModel>>() {}.getType();
            catFragment.processFinish(new Gson().fromJson(jsonOutput, listType));
        }
    }
}
