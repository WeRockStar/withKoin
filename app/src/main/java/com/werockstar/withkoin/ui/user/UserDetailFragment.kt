package com.werockstar.withkoin.ui.user


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.werockstar.withkoin.R
import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.ui.user.viewmodel.UserDetailViewModel
import kotlinx.android.synthetic.main.fragment_user_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    private val viewModel: UserDetailViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = user()
        viewModel.getUser(user.login)
        tvName.text = user.login

        Glide.with(this).load(user.avatarUrl).into(ivAvatar)
        viewModel.user.observe(this, Observer {
			tvBio.text = it .bio
		})
    }

    private fun user(): UserResponse {
        val userArgs: UserDetailFragmentArgs by navArgs()
        return userArgs.user
    }
}
