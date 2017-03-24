package com.example.autodoc.appteste.presentation.cadastro;

public interface CreateUserContract {
    interface view {
        void showMessageCreateUser();

        void showMessageCreateUserError();

        void showProgress();

        void hideProgress();

        void setPresenter(Presenter presenter);

        void showFieldIsEmpty();
    }

    interface Presenter {
        void createUser(String nome, String email, String Password);

    }
}
