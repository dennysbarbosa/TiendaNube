package com.tiendanube.service;

import android.content.Context;
import android.os.AsyncTask;
import android.service.voice.VoiceInteractionService;
import com.tiendanube.R;
import com.tiendanube.TiendaNubeApplication;
import com.tiendanube.presentation.activity.GenericActivity;
import com.tiendanube.presentation.activity.HomeActivity;
import com.tiendanube.presentation.fragment.DogFragment;

public abstract class BaseAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result>  {

    protected Context context;

    public BaseAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        HomeActivity homeActivity = ((HomeActivity) context);
        homeActivity.showToast(context.getString(R.string.fail_internet));
        DogFragment dogFragment = (DogFragment) homeActivity.animalsFragmentAdapter.getItem(0);

        if(dogFragment != null){
            dogFragment.showBtnTryAgain();
        }
    }
}
