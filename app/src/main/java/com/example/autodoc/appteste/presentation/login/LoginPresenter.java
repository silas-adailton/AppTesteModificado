package com.example.autodoc.appteste.presentation.login;

import com.example.autodoc.appteste.domain.message.User;
import com.example.autodoc.appteste.domain.message.interactor.LoginInteractor;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class LoginPresenter implements LoginContract.presenter {

    private LoginContract.view mView;
    private LoginInteractor mLoginInteractor;

    @Inject
    public LoginPresenter(LoginContract.view mView, LoginInteractor mLoginInteractor) {
        this.mView = mView;
        this.mLoginInteractor = mLoginInteractor;
    }

    @Override
    public void sigIn(String email, String password) {
        if (email.isEmpty()) {
            mView.showMessageErrorEmailEmpty();
            return;
        }

        if (password.isEmpty()) {
            mView.showMessageErrorPasswordEmpty();
            return;
        }

        mView.showProgress();
        User user = new User(email, password);

        mLoginInteractor.executeLogin(new LoginInteractor.Request(user))
                .subscribeWith(new DisposableObserver() {
                    @Override
                    public void onNext(Object o) {
                        mView.hideProgress();
                        mView.openHomeMessage();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideProgress();
                        mView.showMessageErrorLogin(e);
                    }

                    @Override
                    public void onComplete() {
                        mView.hideProgress();
                    }
                });

    }
}
