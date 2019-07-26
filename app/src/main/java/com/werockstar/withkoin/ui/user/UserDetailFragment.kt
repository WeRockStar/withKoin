package com.werockstar.withkoin.ui.user


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.werockstar.withkoin.R
import kotlinx.android.synthetic.main.fragment_user_detail.*

class UserDetailFragment : Fragment(R.layout.fragment_user_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val args = UserDetailFragmentArgs.fromBundle(it)
            val user = args.user
            tvName.text = user.login
            tvBio.text = user.bio
            Glide.with(this).load(user.url).into(ivAvatar)

        }
    }
}
