package com.werockstar.withkoin.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.werockstar.withkoin.R
import com.werockstar.withkoin.data.remote.response.UserResponse

class UserAdapter(private val user: List<UserResponse>, private val func: (user: UserResponse) -> Unit) :
    RecyclerView.Adapter<UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_view_item, parent, false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int = user.size


    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(user[position], func)
    }
}