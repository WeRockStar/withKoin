package com.werockstar.withkoin.ui.user


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.werockstar.withkoin.R
import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.ui.user.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user.*
import org.koin.android.viewmodel.ext.android.viewModel

class UserFragment : Fragment(R.layout.fragment_user) {

    private val viewModel: UserViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        viewModel.getUserAll()
        viewModel.usersObserve().observe(this, Observer {
            it ?: return@Observer
            setupAdapter(it)
        })
    }

    private fun setupAdapter(users: List<UserResponse>) {
        val adapter = UserAdapter(users) { user ->
            Log.d("Click", user.login)
        }
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
