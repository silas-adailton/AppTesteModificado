package com.example.autodoc.appteste.presentation.home;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    HomeContract.View mView;

    public HomeModule(HomeContract.View mView) {
        this.mView = mView;
    }

    @Provides
    HomeContract.View provideHomeView() {
        return mView;
    }

}
