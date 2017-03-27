package com.example.autodoc.appteste.presentation.cadastro;

public interface CreateUserContract {
    interface view {
        void showMessageCreateUser();

        void showMessageCreateUserError(Throwable e);

        void showProgress();

        void hideProgress();

        void setPresenter(Presenter presenter);

        void showFieldEmailIsEmpty();

        void showFieldSenhaIsEmpty();
    }

    interface Presenter {
        void createUser(String email, String Password);

    }
}
