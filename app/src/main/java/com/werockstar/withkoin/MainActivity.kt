package com.werockstar.withkoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val gson: Gson? by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Koin", "gson is null or not: ${gson != null}")
    }
}
