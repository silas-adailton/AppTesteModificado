package com.example.autodoc.appteste.di;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    Context ProviderContext(Application application) {
        return application.getApplicationContext();
    }
}
