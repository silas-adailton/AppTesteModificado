package com.example.autodoc.appteste.presentation.login;

import com.example.autodoc.appteste.domain.message.interactor.LoginInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    LoginContract.view providerLoginView(LoginActivity loginActivity) {
        return loginActivity;
    }

    @Provides
    LoginContract.presenter providerLoginPresenter(LoginContract.view view, LoginInteractor loginInteractor) {

        return new LoginPresenter(view, loginInteractor);
    }
}
