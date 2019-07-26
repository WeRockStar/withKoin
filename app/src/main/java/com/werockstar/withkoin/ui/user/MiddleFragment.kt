package com.werockstar.withkoin.ui.user


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.werockstar.withkoin.R
import kotlinx.android.synthetic.main.fragment_middle.*


class MiddleFragment : Fragment(R.layout.fragment_middle) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAction.setOnClickListener {
            findNavController().navigate(R.id.last_action)
        }
    }

}
