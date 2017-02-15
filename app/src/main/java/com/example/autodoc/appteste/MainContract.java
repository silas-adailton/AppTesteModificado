package com.example.autodoc.appteste;

/**
 * Created by autodoc on 06/02/17.
 */

public interface MainContract {

    interface MainView {
        void errorMessage();

        void sucess();

        void openDisplayMessageActivity();

        void setPresenter(MainContract.MainPresenter presenter);

    }

    interface MainPresenter {
        void validaCampo(String texto);

    }

}
