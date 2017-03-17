package com.example.autodoc.appteste.domain.message;

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
        return this.mensagem;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Home home = (Home) obj;
        return super.equals(obj);
    }
}




