package com.example.autodoc.appteste.domain.home.interactor;


import com.example.autodoc.appteste.data.Repository;
import com.example.autodoc.appteste.data.RepositoryExecutor;
import com.example.autodoc.appteste.domain.home.Home;
import com.example.autodoc.appteste.domain.home.InteractorExecutor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
            public void onSuccess(List<Object> object) {

            }

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

    public void executeList(final InteractorExecutor homeInteractorExecutor) {
        mRepository.listar(new RepositoryExecutor() {
            @Override
            public void onSuccess(List<Object> list) {

                Collections.sort(list, new Comparator<Object>() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return ((Home) o1).getMensagem().compareTo(((Home) o2).getMensagem());
                    }
                });

                homeInteractorExecutor.onSuccess(list);
            }

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

        private Home mMessage;

        public Request(Home message) {
            this.mMessage = message;
        }

        public Home getMessage() {
            return mMessage;
        }


    }

}
