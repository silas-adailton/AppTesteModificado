package com.example.autodoc.appteste.presentation.home;


import java.util.List;

public interface HomeContract {

    interface View {

        void showErrorMessage(String message);

        void showErrorFieldEmpty();

        void showMessageSuccess();

        void openDisplayMessageActivity();

        void setmPresenter(Presenter mPresenter);

        void showProgress();

        void hideProgress();

        void showMessage(List<Object> list);
    }

    interface Presenter {
        void saveMessage(String msg);

        void showMessage();

    }

}
