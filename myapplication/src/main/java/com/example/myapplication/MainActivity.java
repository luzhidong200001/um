package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Pre.Pre;
import com.example.myapplication.Vie.vie;
import com.example.myapplication.bA.activity;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends activity<Pre> implements vie {


    @BindView(R.id.ta)
    TabLayout tabLayout;
    @BindView(R.id.v)
    ViewPager viewPager;
    private ArrayList<BEan.DataBean.DatasBean> dat;
    //    private TabLayout viewById;
//    private ViewPager viewById1;

    @Override
    protected void initdat() {
        pre.get();
    }

    @Override
    protected void initivew() {
//        viewById = findViewById(R.id.ta);
//        viewById1 = findViewById(R.id.v);
//
        dat = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();
        fraga fraga = new fraga(dat);
        frag2 frag2 = new frag2();
        fragments.add(fraga);
        fragments.add(frag2);
        title.add("item1");
        title.add("item2");
        adapt adapt = new adapt(getSupportFragmentManager(), fragments, title);
        viewPager.setAdapter(adapt);
        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.getTabAt(0).setIcon(R.drawable.gray_r);
//        tabLayout.getTabAt(1).setIcon(R.drawable.gray_r);

    }

    @Override
    protected void initpre() {
        pre= new Pre();
    }

    @Override
    public int get() {
        return R.layout.activity_main;
    }

    @Override
    public void oncheng(ArrayList<BEan.DataBean.DatasBean> list) {
        dat.addAll(list);
    }
}
