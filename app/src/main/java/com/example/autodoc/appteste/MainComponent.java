package com.example.autodoc.appteste;

import dagger.Component;

@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
    
}
