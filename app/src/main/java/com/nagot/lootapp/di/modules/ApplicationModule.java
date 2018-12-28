package com.nagot.lootapp.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.nagot.lootapp.data.AppDataManager;
import com.nagot.lootapp.data.DataManager;
import com.nagot.lootapp.data.sharedprefs.AppSharedPrefsHelper;
import com.nagot.lootapp.data.sharedprefs.SharedPrefsHelper;

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
    SharedPrefsHelper provideAppSharedPrefsHelper() {
        return new AppSharedPrefsHelper(appContext);
    }

    @Provides
    @Singleton
    DataManager provideDataManager(SharedPrefsHelper sharedPrefsHelper) {
        return new AppDataManager(sharedPrefsHelper);
    }
}
