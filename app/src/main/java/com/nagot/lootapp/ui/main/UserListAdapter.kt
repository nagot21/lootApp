package com.nagot.lootapp.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nagot.lootapp.R
import com.nagot.lootapp.data.network.retrofit.dto.User
import kotlinx.android.synthetic.main.item_list_adapter.view.*

class UserListAdapter :
        RecyclerView.Adapter<UserListAdapter.ListFragmentViewHolder>() {

    private lateinit var context: Context
    private var mUserList: MutableList<User> = mutableListOf()

    fun setUserList(userList: MutableList<User>) {
        mUserList = userList
    }

    fun clearList(){
        mUserList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFragmentViewHolder {
        context = parent.context

        return ListFragmentViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_list_adapter, parent, false))
    }

    override fun getItemCount(): Int {
        return mUserList.size
    }

    override fun onBindViewHolder(holder: ListFragmentViewHolder, position: Int) {
        holder.onBind(mUserList[position])
    }

    inner class ListFragmentViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

        fun onBind(user: User) {

            itemView.adapter_user_name_tv.text = user.name
        }
    }
}