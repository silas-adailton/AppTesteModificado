package com.example.autodoc.appteste;


public class HomeInteractorImpl implements HomeInteractor {

    @Override
    public void valida(String texto, MainListener listener) {
        if (texto.isEmpty()) {
            listener.campoVazio();
            return;
        }
        listener.sucess();
        listener.navigationToHome();
    }
}
