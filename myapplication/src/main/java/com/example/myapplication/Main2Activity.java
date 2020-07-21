package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.net.Api;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar p;
    private TextView l;
    private Button n;
    private FileOutputStream fileOutputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EventBus.getDefault().register(this);

        initView();
        l.setText("0");
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void o(MyMassage i){
//        if (i.getI1()==0){
        p.setMax(i.getI2());
//        }
//        else if (i.getI1()==1){
        p.setProgress(i.getI()/i.getI2()*100);
//            p.setProgress(i.getI1()/i.getLength()*100);
//            l.setText(i+"%");
//        }else{
//            p.setProgress(i.getI());
//            Toast.makeText(Main2Activity.this,"A",Toast.LENGTH_LONG).show();
        l.setText(i.getI()/i.getI2()*100+"%");
//            l.setText("lll");
//        }
//        l.setText(i.getI()+"/");
        Log.i("lll", i.getI()+"");
    }
    private void initView() {
        p = (ProgressBar) findViewById(R.id.p);
        l = (TextView) findViewById(R.id.l);
        n = (Button) findViewById(R.id.n);

        n.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.n:
                in();
                break;
        }
    }

    private void in() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Api.a)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = build.create(Api.class);
        Observable<ResponseBody> responseBodyObservable = api.geT();
        File file = new File("/storage/sdcard0/a10.apk");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        responseBodyObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
                        int length = (int) responseBody.contentLength();
                        InputStream inputStream = responseBody.byteStream();
                        on(file, inputStream, length);
//                            }
//                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("q1", "1");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void on(File file,InputStream in,int length) {
        EventBus.getDefault().post(new MyMassage(0, length, 0));
        byte[] bytes = new byte[1024];
        int lengt = 0;
        int i = 0;
//        Log.i("q1", "12");

        EventBus.getDefault().post("123");
        try {
            fileOutputStream = new FileOutputStream(file);
            while ((lengt = in.read(bytes)) != -1) {
                i+=lengt;
                Thread.sleep(100);
                EventBus.getDefault().post(new MyMassage(1, length,i));
                fileOutputStream.write(bytes, 0, lengt);
                Log.i("ll", lengt+"");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        EventBus.getDefault().post(new MyMassage(2,length,length));
    }
}
