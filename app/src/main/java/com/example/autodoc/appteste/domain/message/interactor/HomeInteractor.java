package com.example.autodoc.appteste.domain.message.interactor;


import com.example.autodoc.appteste.data.Repository;
import com.example.autodoc.appteste.data.RepositoryExecutor;
import com.example.autodoc.appteste.domain.message.Home;
import com.example.autodoc.appteste.domain.message.InteractorExecutor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HomeInteractor {

    public Repository mRepository;

    @Inject
    public HomeInteractor(Repository repository) {
        mRepository = repository;
    }

    public Observable<Home> saveMessage(Home home) {

        return mRepository.saveMessage(new Request(home).getMessage());
    }

    public Observable<List<Home>> listMessage() {

        return mRepository.listMessage()
                .flatMap(list -> Observable.fromIterable(list))
                .sorted(new Comparator<Home>() {
                    @Override
                    public int compare(Home o1, Home o2) {
                        return o1.getMensagem().compareTo(o2.getMensagem());
                    }
                })
                .toList().toObservable();

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

        private Home mHome;

        public Request(Home home) {
            this.mHome = home;
        }

        public Home getMessage() {
            return mHome;
        }


    }

}
