package com.nagot.lootapp.di.components;

import com.nagot.lootapp.LootApplication;
import com.nagot.lootapp.data.DataManager;
import com.nagot.lootapp.data.network.retrofit.RetrofitInitializer;
import com.nagot.lootapp.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)

public interface ApplicationComponent {

    void inject(LootApplication lootApplication);

    DataManager getDataManager();

    RetrofitInitializer getRetrofitInitializer();
}
