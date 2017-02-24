package com.example.autodoc.appteste.domain.home;


public interface InteractorExecutor {

    void onSuccess(Object object);

    void onError(Throwable e);

    void onCompleted();

}
