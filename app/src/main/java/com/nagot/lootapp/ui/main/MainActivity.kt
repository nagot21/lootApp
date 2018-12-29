package com.nagot.lootapp.ui.main

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.nagot.lootapp.ui.base.BaseActivity
import com.nagot.lootapp.R
import com.nagot.lootapp.data.network.retrofit.dto.UsersListResponse
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainViewInterface {

    @Inject
    lateinit var mPresenter: MainPresenterInterface<MainViewInterface>

    @Inject
    lateinit var mAdapter: UserListAdapter

    private fun prepareRecyclerView() {

        if (main_recycler_view.layoutManager == null) {
            val mLayoutManager = LinearLayoutManager(this)
            main_recycler_view.layoutManager = mLayoutManager
            main_recycler_view.itemAnimator = DefaultItemAnimator()
            main_recycler_view.adapter = mAdapter

            /*ItemTouchHelper(itemTouchHelperCallback)
                    .attachToRecyclerView(pokemonRecyclerView)*/

        }
    }

    override fun setUp() {

        getActivityComponent().inject(this)

        prepareRecyclerView()

        mPresenter.onAttach(this)
    }

    override fun getActivityLayout(): Int {
        return R.layout.activity_main
    }

    override fun showProgressBar() {
        main_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        main_progress_bar.visibility = View.GONE
    }

    override fun showNoConnection() {
        main_no_connection_tv.visibility = View.VISIBLE
    }

    override fun hideNoConnection() {
        main_no_connection_tv.visibility = View.GONE
    }

    override fun loadUsersToAdapter(usersListResponse: UsersListResponse) {
        hideProgressBar()

        mAdapter.setUserList(usersListResponse)
    }
}
