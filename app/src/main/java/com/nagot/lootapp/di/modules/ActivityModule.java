package com.nagot.lootapp.di.modules;

import android.support.v7.app.AppCompatActivity;

import com.nagot.lootapp.di.scopes.PerActivity;
import com.nagot.lootapp.ui.main.MainPresenter;
import com.nagot.lootapp.ui.main.MainPresenterInterface;
import com.nagot.lootapp.ui.main.MainViewInterface;
import com.nagot.lootapp.ui.main.UserListAdapter;

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

    @PerActivity
    @Provides
    MainPresenterInterface<MainViewInterface> provideMainPresenter(
            MainPresenter<MainViewInterface> presenter) {
        return presenter;
    }

    @PerActivity
    @Provides
    UserListAdapter provideUserListAdapter() {
        return new UserListAdapter();
    }
}
