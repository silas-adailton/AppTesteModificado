package com.example.autodoc.appteste.domain.home;

public class home {

    private String mensagem;

    public home() {
    }

    public home(String mensagem) {
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




