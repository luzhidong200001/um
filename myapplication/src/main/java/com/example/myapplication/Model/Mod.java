package com.example.myapplication.Model;

import android.util.Log;

import com.example.myapplication.BEan;
import com.example.myapplication.Pre.Pre;
import com.example.myapplication.b;
import com.example.myapplication.bA.model;
import com.example.myapplication.net.Api;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Mod extends model {
    public void get(b pr) {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Api.i).build();
        Api api = build.create(Api.class);
        Observable<BEan> obo = api.obo();
        obo.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BEan>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addcom(d);
                    }

                    @Override
                    public void onNext(BEan bEan) {
                        List<BEan.DataBean.DatasBean> datas = bEan.getData().getDatas();
                        Log.i("Aa",bEan.getErrorMsg()+"");
                        pr.ok((ArrayList<BEan.DataBean.DatasBean>) datas);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("Aa", e+"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
