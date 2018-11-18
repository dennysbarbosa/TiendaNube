package com.tiendanube.service;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tiendanube.R;
import com.tiendanube.presentation.activity.GenericActivity;
import com.tiendanube.presentation.fragment.CatFragment;
import com.tiendanube.presentation.fragment.DogFragment;

public abstract class BaseAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result>  {

    protected Fragment fragment;

    public BaseAsyncTask(Fragment fragment) {
        this.fragment = fragment;
    }

    /*
     * realiza a exibicao de nova tentativa para o fragmento especifico.
     */
    @Override
    protected void onCancelled() {
        super.onCancelled();

        if(fragment instanceof DogFragment) {

            DogFragment dogFragment = (DogFragment) fragment;
            if (dogFragment != null) {

                dogFragment.progressBar.setVisibility(View.GONE);
                dogFragment.showBtnTryAgain();
            }
        }else{

            CatFragment catFragment = (CatFragment) fragment;
            if (catFragment != null) {

                catFragment.progressBarCat.setVisibility(View.GONE);
                catFragment.showBtnTryAgainCat();
            }

        }

        ((GenericActivity) fragment.getActivity()).showToast(fragment.getActivity().getString(R.string.fail_internet));
    }
}
