package com.tiendanube.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.tiendanube.R;

public class SplashScreenActivity extends GenericActivity implements Runnable {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        application.deviceFullScreen(this);
        setContentView(R.layout.splash_screen_activity);
        new Handler().postDelayed(this, 1500);
    }

    @Override
    public void run() {

        finish();
        startActivity(new Intent(this, HomeActivity.class));
    }
}
