package com.example.autodoc.appteste.presentation.cadastro;

import com.example.autodoc.appteste.MainComponent;
import com.example.autodoc.appteste.data.RepositoryComponent;

import dagger.Component;

@Component(dependencies = {MainComponent.class, RepositoryComponent.class}, modules = {CreateUserModule.class})
public interface CreateUserComponent {
    void inject(CreateUserActivity createUserActivity);
}
