package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class adapt extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> arrayList;
    private ArrayList<String> context;

    public adapt(@NonNull FragmentManager fm, ArrayList<Fragment> arrayList,ArrayList<String> context) {
        super(fm);
        this.arrayList = arrayList;
        this.context = context;
    }

    //        super(fm, behavior);
//        this.arrayList = arrayList;
//        this.context = context;
//    }
//
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.get(position);
    }
}
