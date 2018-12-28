package com.nagot.lootapp.ui.base

import com.nagot.lootapp.data.DataManager
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 *   Created by IanNagot on 28/12/2018
 */
open class BasePresenter<V: MvpView>
@Inject constructor(private val mCompositeDisposable: CompositeDisposable,
                    private val mDataManager: DataManager): MvpPresenter<V> {

    private var mMvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mMvpView = mvpView
    }

    override fun onDetach() {
        mCompositeDisposable.dispose()
        mMvpView = null
    }

    fun isViewAttached(): Boolean {
        return mMvpView != null
    }

    fun getMvpView(): V? = mMvpView

    fun getCompositeDisposable() = mCompositeDisposable

    fun getDataManager() = mDataManager
}