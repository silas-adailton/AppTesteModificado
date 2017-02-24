package com.example.autodoc.appteste.domain.home.interactor;


import com.example.autodoc.appteste.data.Repository;
import com.example.autodoc.appteste.data.RepositoryExecutor;
import com.example.autodoc.appteste.domain.home.InteractorExecutor;

import javax.inject.Inject;

public class HomeInteractor {

    public Repository mRepository;

    @Inject
    public HomeInteractor(Repository repository) {
        mRepository = repository;
    }

    public void execute(Request request, final InteractorExecutor homeInteractorExecutor) {
        mRepository.saveMessage(request.getMessage(), new RepositoryExecutor() {

            @Override
            public void onSuccess(Object object) {
                homeInteractorExecutor.onSuccess(object);
            }

            @Override
            public void onError(Throwable e) {
                homeInteractorExecutor.onError(e);
            }

            @Override
            public void onCompleted() {
                homeInteractorExecutor.onCompleted();
            }

        });
    }

    public static final class Request {

        private String mMessage;

        public Request(String message) {
            this.mMessage = message;
        }

        public String getMessage() {
            return mMessage;
        }
    }

}
