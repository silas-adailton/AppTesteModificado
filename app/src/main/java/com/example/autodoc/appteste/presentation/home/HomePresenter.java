package com.example.autodoc.appteste.presentation.home;

import com.example.autodoc.appteste.domain.home.Home;
import com.example.autodoc.appteste.domain.home.InteractorExecutor;
import com.example.autodoc.appteste.domain.home.interactor.HomeInteractor;

import java.util.List;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private HomeInteractor mHomeInteractor;

    @Inject
    public HomePresenter(HomeContract.View mView, HomeInteractor interactor) {
        this.mView = mView;
        this.mView.setmPresenter(this);
        mHomeInteractor = interactor;
    }

    @Inject
    public void setupListeners() {
        mView.setmPresenter(this);
    }

    @Override
    public void saveMessage(String msg) {
        Home home = new Home();
        home.setMensagem(msg);

        if (msg.isEmpty()) {
            mView.showErrorFieldEmpty();
            return;
        }
        mView.showProgress();
        mHomeInteractor.execute(new HomeInteractor.Request(home), new InteractorExecutor() {
            @Override
            public void onSuccess(List<Object> object) {

            }

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

    @Override
    public void showMessage() {
        mView.showProgress();
        mHomeInteractor.executeList(new InteractorExecutor() {
            @Override
            public void onSuccess(List<Object> object) {
                mView.hideProgress();
                mView.showMessage(object);
            }

            @Override
            public void onSuccess(Object object) {

            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMessage(e.getMessage());

            }

            @Override
            public void onCompleted() {

            }
        });

    }

}
