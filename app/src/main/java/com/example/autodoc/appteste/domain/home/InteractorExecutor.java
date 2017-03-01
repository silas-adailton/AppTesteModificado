package com.example.autodoc.appteste.domain.home;


import java.util.List;

public interface InteractorExecutor {
    void onSuccess(List<Object> object);

    void onSuccess(Object object);

    void onError(Throwable e);

    void onCompleted();

}
