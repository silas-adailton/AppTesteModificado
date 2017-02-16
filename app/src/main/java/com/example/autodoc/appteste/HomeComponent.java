package com.example.autodoc.appteste;

import dagger.Component;

@Component(modules = {HomePresenterModule.class,HomeViewModule.class})
public interface HomeComponent {

    void inject(HomeActivity homeActivity);
    
}
