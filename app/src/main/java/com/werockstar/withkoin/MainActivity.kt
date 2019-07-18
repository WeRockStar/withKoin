package com.werockstar.withkoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.werockstar.withkoin.usecase.GetUsersUseCase
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val useCase: GetUsersUseCase? by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Koin", "Inject success: ${useCase != null}")
    }
}
