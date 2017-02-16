package com.example.autodoc.appteste;

/**
 * Created by autodoc on 10/02/17.
 */

public interface HomeInteractor {
    interface MainListener{
        void campoVazio();
        void sucess();
        void navigationToHome();
    }
    void valida(String texto,MainListener listener);
}
