package com.example.autodoc.appteste.presentation.home;


import com.example.autodoc.appteste.domain.message.Home;

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

        void showMessage(List<Home> list);
    }

    interface Presenter {

        void save(String msg);

        void showListMessage();

        void saveMessage(String msg);

        void showMessage();

    }

}
