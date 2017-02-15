package com.example.autodoc.appteste;

import android.text.TextUtils;

import javax.inject.Inject;


public class MainInteractorImpl implements MainInteractor {

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
