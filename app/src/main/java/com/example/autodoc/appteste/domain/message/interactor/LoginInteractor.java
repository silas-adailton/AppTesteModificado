package com.example.autodoc.appteste.domain.message.interactor;

import com.example.autodoc.appteste.data.RepositoryUser;
import com.example.autodoc.appteste.domain.message.User;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginInteractor {

    RepositoryUser mRepositoryUser;

    @Inject
    public LoginInteractor(RepositoryUser mRepositoryUser) {
        this.mRepositoryUser = mRepositoryUser;
    }

    public Observable executeLogin(Request request) {
        return mRepositoryUser.sigIn(request.getUser())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static final class Request {

        private User user;

        public Request(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}
