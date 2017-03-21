package com.example.autodoc.appteste;

import android.app.Application;

import com.example.autodoc.appteste.data.DaggerRepositoryComponent;
import com.example.autodoc.appteste.data.FirebaseModule;
import com.example.autodoc.appteste.data.RepositoryComponent;


public class MainApplication extends Application {
    private static MainComponent sMainComponent;
    private static RepositoryComponent sRepositoryComponent;
    // private static RepositoryUserComponent sRepositoryUserComponent;

    public static MainComponent getsMainComponent() {
        return sMainComponent;
    }

    public static RepositoryComponent getsRepositoryComponent() {
        return sRepositoryComponent;
    }

 /*   public static RepositoryUserComponent getsRepositoryUserComponent(){
        return sRepositoryUserComponent;
    }*/

    @Override
    public void onCreate() {
        super.onCreate();

        sMainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(getApplicationContext()))
                .build();

        sRepositoryComponent = DaggerRepositoryComponent.builder()
                .firebaseModule(new FirebaseModule())
                .build();

        /*sRepositoryUserComponent = DaggerRepositoryUserComponent.builder()
                .firebaseModule(new FirebaseModule())
                .build();*/
    }
}
