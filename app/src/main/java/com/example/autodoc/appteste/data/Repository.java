package com.example.autodoc.appteste.data;

import com.example.autodoc.appteste.domain.home.Home;

public interface Repository {
    void saveMessage(Home home, RepositoryExecutor repositoryExecutor);

    void listar(RepositoryExecutor repositoryExecutor);
}
