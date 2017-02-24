package com.example.autodoc.appteste.data;


public interface RepositoryExecutor {

    void onSuccess(Object object);

    void onError(Throwable e);

    void onCompleted();

}
