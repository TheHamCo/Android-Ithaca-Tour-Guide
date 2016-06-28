package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Adapter for paging/tabs
 */
public class AttractionPagerAdapter extends FragmentPagerAdapter {

    // Require context in order to use getPageTitle
    Context context;

    public AttractionPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CornellFragment();
            case 1:
                return new ParksFragment();
            case 2:
                return new StudySpotFragment();
            case 3:
                return new FoodFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return context.getString(R.string.category_cornell);
            case 1:
                return context.getString(R.string.category_parks);
            case 2:
                return context.getString(R.string.category_study);
            case 3:
                return context.getString(R.string.category_food);
            default:
                return null;
        }
    }
}
