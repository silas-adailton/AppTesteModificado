package com.example.autodoc.appteste.presentation.cadastro;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateUserModule {

    CreateUserContract.view mView;

    public CreateUserModule(CreateUserContract.view mView) {
        this.mView = mView;
    }

    @Provides
    CreateUserContract.view providerView() {
        return mView;
    }
}
