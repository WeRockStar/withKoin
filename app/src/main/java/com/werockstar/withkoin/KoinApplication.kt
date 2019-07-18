package com.werockstar.withkoin

import android.app.Application
import com.werockstar.withkoin.di.appModule
import com.werockstar.withkoin.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(appModule, networkModule)
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@KoinApplication)
            modules(modules)
        }
    }
}