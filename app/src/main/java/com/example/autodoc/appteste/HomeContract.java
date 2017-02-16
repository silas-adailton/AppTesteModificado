package com.example.autodoc.appteste;

/**
 * Created by autodoc on 06/02/17.
 */

public interface HomeContract {

    interface HomeContractView {
        void errorMessage();

        void sucess();

        void openDisplayMessageActivity();

        void setPresenter(HomeContractPresenter presenter);

    }

    interface HomeContractPresenter {
        void validaCampo(String texto);

    }

}
