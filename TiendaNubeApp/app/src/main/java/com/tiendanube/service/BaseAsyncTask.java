package com.tiendanube.service;

import android.content.Context;
import android.os.AsyncTask;
import android.service.voice.VoiceInteractionService;
import com.tiendanube.TiendaNubeApplication;
import com.tiendanube.presentation.activity.GenericActivity;

public abstract class BaseAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result>  {

    protected Context context;

    public BaseAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        ((GenericActivity) context).showToast("");
    }
}
