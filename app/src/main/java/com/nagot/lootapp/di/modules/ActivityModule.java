package com.nagot.lootapp.di.modules;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    AppCompatActivity provideAppCompatActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }

    /*@PerActivity
    @Provides
    MainPresenterInterface<MainView> provideMainPresenter(
            MainPresenter<MainView> presenter) {
        return presenter;
    }*/


}
