package com.tiendanube.presentation.activity;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.tiendanube.R;
import com.tiendanube.TiendaNubeApplication;

public class GenericActivity extends AppCompatActivity {

    public TiendaNubeApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        application = ((TiendaNubeApplication) getApplication());
    }

    public void showToast(String msg){
        Toast.makeText(getApplicationContext(), "msg", Toast.LENGTH_LONG);
    }

    public void animationView(View view){

        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.click_animation));
    }
}
