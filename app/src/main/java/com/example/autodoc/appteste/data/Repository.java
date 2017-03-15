package com.example.autodoc.appteste.data;

import com.example.autodoc.appteste.domain.message.Home;

import java.util.List;

import io.reactivex.Observable;

public interface Repository {

    Observable<Home> saveMessage(Home home);

    Observable<List<Home>> listMessage();

    void saveMessage(Home home, RepositoryExecutor repositoryExecutor);

    void listar(RepositoryExecutor repositoryExecutor);

}
