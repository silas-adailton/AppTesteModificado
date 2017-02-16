package com.example.autodoc.appteste;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.HomeContractPresenter, HomeInteractor.MainListener {
    private HomeContract.HomeContractView view;
    private HomeInteractor homeInteractor;

    public HomePresenter(HomeContract.HomeContractView view, HomeInteractor interactor) {
        this.view = view;
        this.view.setPresenter(this);
        homeInteractor = interactor;
    }

    @Inject
    public void setupListeners() {
        view.setPresenter(this);
    }

    @Override
    public void validaCampo(String texto) {
        homeInteractor.valida(texto, this);
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
