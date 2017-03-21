package com.example.autodoc.appteste;

import android.app.Application;

import com.example.autodoc.appteste.data.FirebaseModule;
import com.example.autodoc.appteste.data.RepositoryComponent;


public class MainApplication extends Application {
    private static MainComponent sMainComponent;
    private static RepositoryComponent sRepositoryComponent;

    public static MainComponent getsMainComponent() {
        return sMainComponent;
    }

    public static RepositoryComponent getsRepositoryComponent() {
        return sRepositoryComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sMainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(getApplicationContext()))
                .build();

        sRepositoryComponent = DaggerRepositoryComponent.builder()
                .firebaseModule(new FirebaseModule())
                .build();
    }
}
