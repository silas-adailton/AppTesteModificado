package com.example.autodoc.appteste.presentation.home;

/**
 * Created by autodoc on 06/02/17.
 */

public interface HomeContract {

    interface View {

        void showErrorMessage(String message);

        void showErrorFieldEmpty();

        void showMessageSuccess();

        void openDisplayMessageActivity();

        void setPresenter(Presenter presenter);

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void saveMessage(String msg);

    }

}
