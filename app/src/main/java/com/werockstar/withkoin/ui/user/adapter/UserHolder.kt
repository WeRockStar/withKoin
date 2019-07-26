package com.werockstar.withkoin.ui.user.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.werockstar.withkoin.data.remote.response.UserResponse
import kotlinx.android.synthetic.main.user_view_item.view.*

class UserHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(user: UserResponse, func: (user: UserResponse) -> Unit) {
        view.tvUser.text = user.login
        Glide.with(view.context).load(user.avatarUrl).into(view.ivAvatar)
        view.root.setOnClickListener { func(user) }
    }

}