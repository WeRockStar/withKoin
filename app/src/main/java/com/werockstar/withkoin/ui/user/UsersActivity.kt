package com.werockstar.withkoin.ui.user

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.werockstar.withkoin.R
import com.werockstar.withkoin.ui.user.viewmodel.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class UsersActivity : AppCompatActivity() {

    private val viewModel: UserViewModel? by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        Log.d("Koin", "Inject success: ${viewModel != null}")
        viewModel?.getUserAll()
    }
}
