package com.example.autodoc.appteste.presentation.login;

public interface LoginContract {

    interface view {
        void showMessageErrorEmailEmpty();

        void showMessageErrorPasswordEmpty();

        void showMessageErrorLogin(Throwable e);

        void mauthStateListener();

        void showProgress();

        void hideProgress();

        void setPresenter(LoginContract.presenter presenter);

    }

    interface presenter {

        void sigIn(String email, String password);

    }
}
