package com.example.myapplication.bA;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class model {
    private CompositeDisposable compositeDisposa;
    public void addcom(Disposable d){
        if (compositeDisposa==null){
            synchronized (this){
                if (compositeDisposa==null){
                    compositeDisposa=new CompositeDisposable();
                }
            }
        }
        compositeDisposa.add(d);
    }
    public void Disposa(){compositeDisposa.dispose();}
    public void rem(Disposable disposable){
        if (compositeDisposa!=null){
            compositeDisposa.remove(disposable);
        }
    }
}
