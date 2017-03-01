package com.example.autodoc.appteste.domain.home;

public class Home {

    private String mensagem;

    public Home() {
    }

    public Home(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Mensagem: " + this.mensagem;
    }

}




