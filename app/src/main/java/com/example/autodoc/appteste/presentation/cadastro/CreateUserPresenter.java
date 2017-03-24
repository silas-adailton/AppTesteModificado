package com.example.autodoc.appteste.presentation.cadastro;

import com.example.autodoc.appteste.data.RepositoryUser;

import javax.inject.Inject;

public class CreateUserPresenter implements CreateUserContract.Presenter {
    CreateUserContract.view mView;
    RepositoryUser repositoryUser;

    @Inject
    public CreateUserPresenter(CreateUserContract.view mView, RepositoryUser repositoryUser) {
        this.mView = mView;
        this.repositoryUser = repositoryUser;
    }

    @Inject
    public void setUpListener() {
        this.mView.setPresenter(this);
    }


    @Override
    public void createUser(String nome, String email, String senha) {

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            mView.showFieldIsEmpty();
        }

    }
}
