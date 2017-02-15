package com.example.autodoc.appteste;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private MainContract.MainView mainView;

    public MainModule(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    @Provides
    MainContract.MainView provideMainView() {
        return mainView;
    }

    @Provides
    MainInteractor provideMainInteractor() {
        return new MainInteractorImpl();
    }

    @Provides
    MainContract.MainPresenter proviMainPresenter(MainContract.MainView view, MainInteractor interactor) {
        return new MainPresenter(view, interactor);
    }
}
