package com.example.autodoc.appteste;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeViewModule {

    HomeContract.HomeContractView view;

    public HomeViewModule(HomeContract.HomeContractView view) {
        this.view = view;
    }

    @Provides
    HomeContract.HomeContractView provideHomeView(){
        return view;
    }

}
