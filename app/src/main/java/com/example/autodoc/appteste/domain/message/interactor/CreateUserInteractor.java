package com.example.autodoc.appteste.domain.message.interactor;

import com.example.autodoc.appteste.data.RepositoryUser;
import com.example.autodoc.appteste.domain.message.User;

import javax.inject.Inject;

public class CreateUserInteractor {

    RepositoryUser mRepositoryUser;

    @Inject
    public CreateUserInteractor(RepositoryUser mRepositoryUser) {
        this.mRepositoryUser = mRepositoryUser;
    }

    public static class Request {

        private User user;

        public Request(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}
