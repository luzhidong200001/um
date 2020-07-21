package com.example.myapplication.bA;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import butterknife.ButterKnife;

public abstract class activity<P extends presenter> extends AppCompatActivity implements view {

    public P pre;
    @Override
    public void on(String a) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(get()); ButterKnife.bind(this);
        initpre();
        if (pre!=null){
            pre.bind(this);
        }
        initivew();
        initdat();
    }

    protected abstract void initdat();

    protected abstract void initivew();

    protected abstract void initpre();

    public abstract int get();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pre!=null){
            pre.ond();
            pre=null;
        }
    }
}
