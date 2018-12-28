package com.nagot.lootapp.di.modules;

import android.support.v7.app.AppCompatActivity;

import com.nagot.lootapp.ui.base.BaseFragment;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;
    private BaseFragment mBaseFragment;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    public ActivityModule(AppCompatActivity activity, BaseFragment baseFragment) {
        this.mActivity = activity;
        this.mBaseFragment = baseFragment;
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
