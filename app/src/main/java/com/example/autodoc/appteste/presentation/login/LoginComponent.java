package com.example.autodoc.appteste.presentation.login;

import com.example.autodoc.appteste.MainComponent;
import com.example.autodoc.appteste.data.RepositoryComponent;

import dagger.Component;

@Component(dependencies = {MainComponent.class, RepositoryComponent.class}, modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);
}
