package com.example.autodoc.appteste.presentation.home;

import com.example.autodoc.appteste.domain.message.Home;
import com.example.autodoc.appteste.domain.message.InteractorExecutor;
import com.example.autodoc.appteste.domain.message.interactor.HomeInteractor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

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
    public void save(String msg) {
        Home home = new Home();
        home.setMensagem(msg);

        if (msg.isEmpty()) {
            mView.showErrorFieldEmpty();
            return;
        }
        mView.showProgress();

        mHomeInteractor.saveMessage(home).subscribeWith(new DisposableObserver<Home>() {
            @Override
            public void onNext(Home home) {

            }

            @Override
            public void onError(Throwable e) {
                mView.hideProgress();
                mView.showErrorMessage(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.hideProgress();
                mView.showMessageSuccess();

            }
        });

    }

    @Override
    public void showListMessage() {
        mView.showProgress();

        mHomeInteractor.listMessage().subscribeWith(new DisposableObserver<List<Home>>() {
            @Override
            public void onNext(List<Home> homes) {
                mView.showMessage(homes);
            }

            @Override
            public void onError(Throwable e) {
                mView.hideProgress();
                mView.showErrorMessage(e.getMessage());
            }

            @Override
            public void onComplete() {
                mView.hideProgress();

            }
        });
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
                // mView.showMessage(object);
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
