package com.example.autodoc.appteste.di;

import android.app.Application;
import android.content.Context;

import com.example.autodoc.appteste.MainApplication;
import com.example.autodoc.appteste.data.FirebaseModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationModule.class,
        FirebaseModule.class

})
public interface ApplicationComponent {

    void inject(MainApplication app);

    Context getContext();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
