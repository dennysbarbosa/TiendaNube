package com.tiendanube.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import com.tiendanube.R;
import com.tiendanube.presentation.adapter.AnimalsFragmentAdapter;
import com.tiendanube.service.DogServiceAsyncTask;

public class HomeActivity extends GenericActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    public AnimalsFragmentAdapter animalsFragmentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        viewPager = findViewById(R.id.view_pager);
        animalsFragmentAdapter = new AnimalsFragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(animalsFragmentAdapter);

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
