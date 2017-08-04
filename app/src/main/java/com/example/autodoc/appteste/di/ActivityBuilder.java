package com.example.autodoc.appteste.di;


import com.example.autodoc.appteste.presentation.cadastro.CreateUserActivity;
import com.example.autodoc.appteste.presentation.cadastro.CreateUserModule;
import com.example.autodoc.appteste.presentation.home.HomeActivity;
import com.example.autodoc.appteste.presentation.home.HomeModule;
import com.example.autodoc.appteste.presentation.login.LoginActivity;
import com.example.autodoc.appteste.presentation.login.LoginModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = CreateUserModule.class)
    abstract CreateUserActivity bindCreateUserActivity();

    @ContributesAndroidInjector(modules = HomeModule.class)
    abstract HomeActivity bindHomeActivity();

}
