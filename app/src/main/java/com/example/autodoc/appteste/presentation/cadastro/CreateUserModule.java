package com.example.autodoc.appteste.presentation.cadastro;

import com.example.autodoc.appteste.data.RepositoryUser;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateUserModule {

    @Provides
    CreateUserContract.view providerCreateView(CreateUserActivity createUserActivity) {
        return createUserActivity;
    }

    @Provides
    CreateUserPresenter providerCreatePresenter(CreateUserContract.view view, RepositoryUser repositoryUser) {

        return new CreateUserPresenter(view, repositoryUser);
    }
}
