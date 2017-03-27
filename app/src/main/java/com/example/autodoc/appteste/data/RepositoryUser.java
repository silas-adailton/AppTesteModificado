package com.example.autodoc.appteste.data;

import com.example.autodoc.appteste.domain.message.User;

import io.reactivex.Observable;

public interface RepositoryUser {

    Observable<User> sigIn(User user);

    Observable<User> createUser(User user);
}
