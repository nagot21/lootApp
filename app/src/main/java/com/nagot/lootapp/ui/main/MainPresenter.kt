package com.nagot.lootapp.ui.main

import com.nagot.lootapp.data.DataManager
import com.nagot.lootapp.data.network.retrofit.RetrofitInitializer
import com.nagot.lootapp.ui.base.BasePresenter
import com.nagot.lootapp.utils.ConnectionUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter<V : MainViewInterface>
@Inject constructor(mCompositeDisposable: CompositeDisposable, mDataManager: DataManager,
                    private val mRetrofitInitializer: RetrofitInitializer) :
        BasePresenter<V>(mCompositeDisposable, mDataManager), MainPresenterInterface<V> {

    private fun isInternetAvailable() = ConnectionUtil
            .isInternetAvailable(getMvpView()?.getBaseActivity()!!.baseContext)

    private fun getUserListFromApi() {
        getCompositeDisposable().add(getDataManager().getUsers(mRetrofitInitializer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    if (userList.isNotEmpty()) {
                        getMvpView()?.loadUsersToAdapter(userList)
                    } else {
                        getMvpView()?.showErrorMessage()
                    }
                },
                        { it.printStackTrace() }))
    }

    override fun getUserList() {
        if (isInternetAvailable()) {
            getUserListFromApi()
        } else {
            getMvpView()?.showNoConnection()
        }
    }
}