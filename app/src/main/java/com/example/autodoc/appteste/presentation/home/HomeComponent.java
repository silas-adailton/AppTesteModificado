package com.example.autodoc.appteste.presentation.home;

import com.example.autodoc.appteste.MainComponent;
import com.example.autodoc.appteste.data.RepositoryComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = {MainComponent.class, RepositoryComponent.class}, modules = {HomeModule.class})
public interface HomeComponent {

    void inject(HomeActivity homeActivity);
    // void inject(LoginActivity loginActivity);

}
