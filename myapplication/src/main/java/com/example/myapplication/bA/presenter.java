package com.example.myapplication.bA;

import java.util.ArrayList;

public abstract class presenter<V extends view>  {
    public V v;
    public ArrayList<model> arrayList=new ArrayList<>();

    public  void addmo(model m){
        arrayList.add(m);

    }
    public presenter(){initpre();}
    public abstract void initpre();
    public void bind(V vie){
        this.v=vie;
    }

    public void ond(){
        v=null;
        for (int i=0;i<arrayList.size();i++){
            arrayList.get(i).Disposa();
        }
    }
}
