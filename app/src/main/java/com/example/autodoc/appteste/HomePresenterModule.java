package com.example.autodoc.appteste;

import dagger.Module;
import dagger.Provides;

@Module
public class HomePresenterModule {

    @Provides
    HomeInteractor provideMainInteractor() {
        return new HomeInteractorImpl();
    }

    @Provides
    HomeContract.HomeContractPresenter provideMainPresenter(HomeContract.HomeContractView view, HomeInteractor interactor) {
        return new HomePresenter(view, interactor);
    }
}
