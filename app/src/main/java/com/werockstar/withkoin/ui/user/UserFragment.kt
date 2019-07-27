package com.werockstar.withkoin.ui.user


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.werockstar.withkoin.R
import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.ui.user.adapter.UserAdapter
import com.werockstar.withkoin.ui.user.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_user.*
import org.koin.android.viewmodel.ext.android.viewModel

class UserFragment : Fragment(R.layout.fragment_user) {

    private val viewModel: UserViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.getUsers()
        viewModel.observe().observe(this, Observer {
            it ?: return@Observer
            setupAdapter(it)
        })

    }

    private fun setupRecyclerView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    private fun setupAdapter(users: List<UserResponse>) {
        val adapter = UserAdapter(users) { user ->
            val directions = UserFragmentDirections.detailAction(user)
            findNavController().navigate(directions)
        }
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
