package com.tiendanube.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import com.tiendanube.R;
import com.tiendanube.presentation.adapter.AnimalsFragmentAdapter;

/*
 * Classe principal com componente View Page associado a intancia da classe AnimalsFragmentAdapter,
 * classe que possui dois fragmentos (CatFragment e DogFragment).
 */

public class HomeActivity extends GenericActivity {

    public AnimalsFragmentAdapter animalsFragmentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        initViews();
    }

    private void initViews(){

        animalsFragmentAdapter = new AnimalsFragmentAdapter(getSupportFragmentManager(), this);
        ViewPager viewPager =  findViewById(R.id.view_pager);
        viewPager.setAdapter(animalsFragmentAdapter);
        ((TabLayout) findViewById(R.id.tab_layout)).setupWithViewPager(viewPager);
    }

}
