package com.werockstar.withkoin.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.werockstar.withkoin.R
import com.werockstar.withkoin.usecase.GetUsersUseCase
import org.koin.android.ext.android.inject

class UsersActivity : AppCompatActivity() {

    private val useCase: GetUsersUseCase? by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        Log.d("Koin", "Inject success: ${useCase != null}")
    }
}
