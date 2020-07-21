package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.storage.OnObbStateChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fraga extends Fragment {

    private RecyclerView viewById;
    private ArrayList<BEan.DataBean.DatasBean> arrayList;

    public fraga(ArrayList<BEan.DataBean.DatasBean> arrayList) {
        this.arrayList = arrayList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.ite, null);
        viewById = inflate.findViewById(R.id.re);
        uii();
        return inflate;
    }

    private void uii() {
        ada ada = new ada(arrayList, getActivity());
        viewById.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewById.setAdapter(ada);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ada.setOn(new ada.onite() {
                    @Override
                    public void on(int position) {
                        Intent intent = new Intent(getActivity(), Main2Activity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
