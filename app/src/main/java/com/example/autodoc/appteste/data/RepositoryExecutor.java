package com.example.autodoc.appteste.data;


import java.util.List;

public interface RepositoryExecutor {

    void onSuccess(List<Object> object);

    void onSuccess(Object object);

    void onError(Throwable e);

    void onCompleted();

}
