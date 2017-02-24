package com.example.autodoc.appteste.presentation.home;

import com.example.autodoc.appteste.domain.home.InteractorExecutor;
import com.example.autodoc.appteste.domain.home.interactor.HomeInteractor;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private HomeInteractor mHomeInteractor;

    @Inject
    public HomePresenter(HomeContract.View mView, HomeInteractor interactor) {
        this.mView = mView;
        this.mView.setPresenter(this);
        mHomeInteractor = interactor;
    }

    @Inject
    public void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void saveMessage(String msg) {
        mView.showProgress();
        mHomeInteractor.execute(new HomeInteractor.Request(msg), new InteractorExecutor() {
            @Override
            public void onSuccess(Object object) {
                mView.showMessageSuccess();
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMessage(e.getMessage());
            }

            @Override
            public void onCompleted() {
                mView.hideProgress();
            }
        });
    }

}
