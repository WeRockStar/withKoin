package com.werockstar.withkoin.core

import kotlinx.coroutines.CoroutineDispatcher

interface ThreadDispatcher {
    fun ui(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun compute(): CoroutineDispatcher
}