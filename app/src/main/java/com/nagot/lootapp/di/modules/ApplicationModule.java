package com.nagot.lootapp.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nagot.lootapp.data.AppDataManager;
import com.nagot.lootapp.data.DataManager;
import com.nagot.lootapp.data.network.AppNetworkManager;
import com.nagot.lootapp.data.network.NetworkManager;
import com.nagot.lootapp.data.network.retrofit.RetrofitInitializer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context appContext;

    public ApplicationModule(@NonNull Context context) {
        this.appContext = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return appContext;
    }

    @Provides
    @Singleton
    RetrofitInitializer provideRetrofitInitializer() {
        return new RetrofitInitializer();
    }

    @Provides
    @Singleton
    NetworkManager provideAppNetworkManager(RetrofitInitializer retrofitInitializer) {
        return new AppNetworkManager(retrofitInitializer);
    }

    @Provides
    @Singleton
    DataManager provideDataManager(NetworkManager networkManager) {
        return new AppDataManager(networkManager);
    }
}
