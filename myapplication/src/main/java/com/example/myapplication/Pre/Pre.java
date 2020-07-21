package com.example.myapplication.Pre;

import com.example.myapplication.BEan;
import com.example.myapplication.Model.Mod;
import com.example.myapplication.Vie.vie;
import com.example.myapplication.b;
import com.example.myapplication.bA.presenter;

import java.util.ArrayList;

public class Pre extends presenter<vie> implements b
{

    private Mod mod;

    @Override
    public void ok(ArrayList<BEan.DataBean.DatasBean> arrayList){
        v.oncheng(arrayList);
    }

    @Override
    public void initpre() {
        mod = new Mod();
        addmo(mod);
    }

    public void get() {
        mod.get(this);
    }
}
