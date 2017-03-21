package com.example.autodoc.appteste.presentation.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    LoginContract.view mView;

    public LoginModule(LoginContract.view mView) {
        this.mView = mView;
    }

    @Provides
    LoginContract.view getmView() {
        return mView;
    }
}
