package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ada extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<BEan.DataBean.DatasBean> arrayList;
    private Context context;

    private onite on;

    public ada(onite on) {
        this.on = on;
    }

    public onite getOn() {
        return on;
    }

    public void setOn(onite on) {
        this.on = on;
    }

    public ada(ArrayList<BEan.DataBean.DatasBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public ArrayList<BEan.DataBean.DatasBean> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<BEan.DataBean.DatasBean> arrayList) {
        this.arrayList = arrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new viewho(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        viewho viewho= (ada.viewho) holder;
        Glide.with(context).load(arrayList.get(position).getEnvelopePic()).into(((viewho) holder).viewById);
        viewho.viewById1.setText(",aan.");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (on!=null){
                    on.on(position);
                }
            }
        });
    }

    public interface onite{
        void on(int position);
    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class viewho extends RecyclerView.ViewHolder {

        private final ImageView viewById;
        private final TextView viewById1;

        public viewho(View inflate) {
            super(inflate);
            viewById = inflate.findViewById(R.id.i);
            viewById1 = inflate.findViewById(R.id.t);
        }
    }
}
