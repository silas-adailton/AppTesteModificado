package com.example.autodoc.appteste;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule extends MainApplication {

    private final Context mContext;

    public MainModule(Context context) {
        this.mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }


}
