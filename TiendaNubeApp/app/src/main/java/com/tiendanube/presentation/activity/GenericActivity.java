package com.tiendanube.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import com.tiendanube.R;
import com.tiendanube.TiendaNubeApplication;

/*
 * Classes base das activities.
 */
public class GenericActivity extends AppCompatActivity {

    public TiendaNubeApplication application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        application = ((TiendaNubeApplication) getApplication());
    }

    /*
     * metodo comum, reponsavel por exibir menssagem.
     */
    public void showToast(String msg){

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    /*
     * metodo comum, reponsavel por animacoes de views.
     */
    public void animationView(View view){

        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.click_animation));
    }
}
