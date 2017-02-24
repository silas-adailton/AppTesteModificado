package com.example.autodoc.appteste.data;

public interface Repository {
    void saveMessage(String msg, RepositoryExecutor repositoryExecutor);

    void listar();
}
