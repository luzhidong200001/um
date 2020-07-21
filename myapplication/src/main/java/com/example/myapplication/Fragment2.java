//package com.example.myapplication;
//
//import android.Manifest;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//
//import androidx.core.app.ActivityCompat;
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;
//
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class Fragment2 extends Fragment {
//
//    private TextView tv;
//    private ProgressBar pb;
//
//    public Fragment2() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_2, container, false);
//        initView(view);
//      //  EventBus.getDefault().register(this);
//        EventBus.getDefault().register(this);
//        checkPermiss();
//        return view;
//    }
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void getMsg(MyMassage myMassage){
//        if(myMassage.getFlag()==0){//设置进度条的最大进度值
//            pb.setMax(myMassage.getMax());
//
//        }else if(myMassage.getFlag()==1){
//            int max = myMassage.getMax();//得到最大进度
//            int progress = myMassage.getProgress();//得到进度
//            //计算百分比
//            pb.setMax(max);
//            pb.setProgress(progress);
//            int a= (int) (((float)progress/max)*100);
//            if(progress==max){
//                Toast.makeText(getContext(), "下载完成", Toast.LENGTH_SHORT).show();
//            }
//            tv.setText("当前下载进度 : "+a+"%");
//        }
//
//    }
//    private void initView(View view) {
////        pb = view.findViewById(R.id.pb);
////        tv = view.findViewById(R.id.tv);
////        Button bnt = view.findViewById(R.id.bnt);
////       bnt.setOnClickListener(new View.OnClickListener() {
////           @Override
////           public void onClick(View v) {
////               Intent intent = new Intent(getContext(), MyServer.class);
////
////               getActivity().startService(intent);
////           }
////       });
//
//    }
//    private void checkPermiss() {
//        int i = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
//        if (i != PackageManager.PERMISSION_GRANTED) {//没有授权，申请权限
//            ActivityCompat.requestPermissions(getActivity(), new String[]{
//                    Manifest.permission.READ_EXTERNAL_STORAGE,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE
//            }, 100);
//        }
//    }
//}
