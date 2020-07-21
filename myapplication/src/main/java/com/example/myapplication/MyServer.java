//package com.example.myapplication;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.IBinder;
//
////import org.greenrobott.eventbus.EventBus;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//import androidx.annotation.Nullable;
//
//import com.example.myapplication.net.Api;
//
//import io.reactivex.Observable;
//import io.reactivex.Observer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.schedulers.Schedulers;
//import okhttp3.ResponseBody;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class MyServer extends Service {
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//       new Thread(){
//           @Override
//           public void run() {
//               super.run();
//               final String path="/storage/sdcard0/aa.apk";
//               Retrofit build = new Retrofit.Builder()
//                       .baseUrl(Api.a)
//                       .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                       .build();
//               Api apiServer = build.create(Api.class);
//               Observable<ResponseBody> apk = apiServer.geT();
//               apk.observeOn(AndroidSchedulers.mainThread())
//                       .subscribeOn(Schedulers.io())
//                       .subscribe(new Observer<ResponseBody>() {
//                           @Override
//                           public void onSubscribe(Disposable d) {
//
//                           }
//
//                           @Override
//                           public void onNext(ResponseBody responseBody) {
//                               long length = responseBody.contentLength();
//                               InputStream inputStream = responseBody.byteStream();
//                              // saveFile(saveFilePath,is,max);//保存文件的方法：读取is里的数据写入到本手机
//                               saveFile(path,inputStream,length);
//                           }
//
//
//
//                           @Override
//                           public void onError(Throwable e) {
//
//                           }
//
//                           @Override
//                           public void onComplete() {
//
//                           }
//                       });
//
//           }
//       }.start();
//        return super.onStartCommand(intent, flags, startId);
//    }
//    private void saveFile(String path, InputStream inputStream, long length) {
//        //设置进度条的最大进度
//      //  EventBus.getDefault().post(new PbMsg(0,(int)max,0));
//     //   FileOutputStream os = null;//创建本地接收文件的输出流，保存文件
//            EventBus.getDefault().post(new MyMassage(0,(int)length,0));
//        FileOutputStream stream=null;
//        try {
//            stream = new FileOutputStream(path);
//            byte[] arr=new byte[1024];
//            int len=0;
//            int count=0;
//            while ((len=inputStream.read(arr))!=-1){
//                stream.write(arr,0,len);
//               // count = count+len;//累加上传进度
//               // EventBus.getDefault().post(new PbMsg(1,(int)max,count));//发送最新进度
//                count+=len;
//                Thread.sleep(1);
//                EventBus.getDefault().post(new MyMassage(1,(int)length,count));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(inputStream !=null){
//                    inputStream.close();
//                }
//                if(stream !=null){
//                    stream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//}
