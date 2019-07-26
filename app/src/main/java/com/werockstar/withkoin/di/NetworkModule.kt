package com.werockstar.withkoin.di

import com.werockstar.withkoin.data.remote.GithubAPI
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        val cacheSize: Long = 10 * 1024 * 1024
        val httpCacheDirectory = File(androidApplication().cacheDir, "http-cache")
        val cache = Cache(httpCacheDirectory, cacheSize)

        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        interceptor
    }
    single {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .baseUrl("https://api.github.com/")
            .build()
    }

    single {
        get<Retrofit>().create(GithubAPI::class.java)
    }
}