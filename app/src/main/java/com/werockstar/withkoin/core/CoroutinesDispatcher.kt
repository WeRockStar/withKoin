package com.werockstar.withkoin.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutinesDispatcher : ThreadDispatcher {

    override fun ui(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.IO
    }

}