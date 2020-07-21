package com.example.myapplication.net;

import com.example.myapplication.BEan;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface Api {
    String   i=" https://www.wanandroid.com/";
    String a="https://alissl.ucdl.pp.uc.cn/";
    @GET("project/list/1/json?cid=294")
    Observable<BEan> obo();
    @GET("fs08/2019/07/05/1/110_17e4089aa3a4b819b08069681a9de74b.apk")
    Observable<ResponseBody> geT();
}
