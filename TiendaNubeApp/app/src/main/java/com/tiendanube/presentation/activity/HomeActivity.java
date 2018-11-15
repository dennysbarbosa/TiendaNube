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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new AnimalsFragmentAdapter(getSupportFragmentManager(), this));

        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        new DogServiceAsyncTask(this).execute();
    }
}
