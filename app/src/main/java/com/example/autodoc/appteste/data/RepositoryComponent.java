package com.example.autodoc.appteste.data;

import dagger.Component;

@Component(modules = {FirebaseModule.class})
public interface RepositoryComponent {

    Repository getRepository();
    RepositoryUser getRepositoryUser();

}
