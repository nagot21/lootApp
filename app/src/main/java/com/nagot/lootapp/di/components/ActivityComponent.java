package com.nagot.lootapp.di.components;

import com.nagot.lootapp.di.modules.ActivityModule;
import com.nagot.lootapp.di.scopes.PerActivity;
import com.nagot.lootapp.ui.main.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = ActivityModule.class,
        dependencies = ApplicationComponent.class)

public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
