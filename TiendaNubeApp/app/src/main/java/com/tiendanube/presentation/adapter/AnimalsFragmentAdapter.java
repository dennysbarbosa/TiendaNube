package com.tiendanube.presentation.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tiendanube.R;
import com.tiendanube.presentation.fragment.CatFragment;
import com.tiendanube.presentation.fragment.DogFragment;

public class AnimalsFragmentAdapter extends FragmentPagerAdapter {

    private Integer[] titles;
    private Fragment[] fragments;
    private Context context;

    public AnimalsFragmentAdapter(FragmentManager fm, Context context) {

        super(fm);
        this.context = context;
        titles = new Integer[]{R.string.title_dogs, R.string.title_cats};
        fragments = new Fragment[]{new DogFragment(), new CatFragment()};
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(titles[position]);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
