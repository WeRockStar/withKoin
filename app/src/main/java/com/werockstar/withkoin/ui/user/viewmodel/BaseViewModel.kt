package com.werockstar.withkoin.ui.user.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

open class BaseViewModel : ViewModel() {
    protected val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("API", exception.message ?: "")
    }
}