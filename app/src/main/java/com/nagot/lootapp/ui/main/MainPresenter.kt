package com.nagot.lootapp.ui.main

import com.nagot.lootapp.data.DataManager
import com.nagot.lootapp.ui.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainViewInterface>
@Inject constructor(mCompositeDisposable: CompositeDisposable, mDataManager: DataManager) :
        BasePresenter<V>(mCompositeDisposable, mDataManager), MainPresenterInterface<V> {

    override fun getUsersList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}