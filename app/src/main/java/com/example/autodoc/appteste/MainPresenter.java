package com.example.autodoc.appteste;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainPresenter implements MainContract.MainPresenter, MainInteractor.MainListener {
    private MainContract.MainView view;
    private MainInteractor mainInteractor;

    public MainPresenter(MainContract.MainView view, MainInteractor interactor) {
        this.view = view;
        this.view.setPresenter(this);
        mainInteractor = interactor;
    }

    @Inject
    public void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void validaCampo(String texto) {
        mainInteractor.valida(texto, this);
    }

    @Override
    public void campoVazio() {
        view.errorMessage();

    }

    @Override
    public void sucess() {
        view.sucess();

    }

    @Override
    public void navigationToHome() {
        view.openDisplayMessageActivity();
    }
}
