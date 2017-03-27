package com.example.autodoc.appteste.presentation.cadastro;

import com.example.autodoc.appteste.data.RepositoryUser;
import com.example.autodoc.appteste.domain.message.User;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class CreateUserPresenter implements CreateUserContract.Presenter {
    CreateUserContract.view mView;
    RepositoryUser mRepositoryUser;

    @Inject
    public CreateUserPresenter(CreateUserContract.view mView, RepositoryUser repositoryUser) {
        this.mView = mView;
        this.mRepositoryUser = repositoryUser;
    }

    @Inject
    public void setUpListener() {
        this.mView.setPresenter(this);
    }


    @Override
    public void createUser(String email, String senha) {

        if (email.isEmpty()) {
            mView.showFieldEmailIsEmpty();
            return;
        }
        if (senha.isEmpty()) {
            mView.showFieldSenhaIsEmpty();
        }

        mView.showProgress();
        User user = new User(email, senha);
        mRepositoryUser.createUser(user).subscribeWith(new DisposableObserver<User>() {
            @Override
            public void onNext(User user) {


            }

            @Override
            public void onError(Throwable e) {
                mView.hideProgress();
                mView.showMessageCreateUserError(e);

            }

            @Override
            public void onComplete() {
                mView.hideProgress();
                mView.showMessageCreateUser();

            }
        });


    }
}
