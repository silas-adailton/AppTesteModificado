package com.example.autodoc.appteste.presentation.home;

import com.example.autodoc.appteste.domain.message.interactor.HomeInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    HomeContract.View providerHomeView(HomeActivity homeActivity) {
        return homeActivity;
    }

    @Provides
    HomeContract.Presenter providerHomePresenter(HomeContract.View view, HomeInteractor homeInteractor) {
        return new HomePresenter(view, homeInteractor);

    }

}
