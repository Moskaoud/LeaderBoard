package com.moskaoud.leaderboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFPAdapter  extends FragmentPagerAdapter {
    Context context;
    public MyFPAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new LearningFragment();
        else return new SkillIQFragment();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return context.getResources().getString(R.string.learning_leaders);
        else
            return context.getResources().getString(R.string.skill_iq);
    }
    @Override
    public int getCount() {
        return 2;
    }
}
