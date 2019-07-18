package com.werockstar.withkoin.di

import com.werockstar.withkoin.data.remote.GithubAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        /**
         * TODO: Caching enable
         */
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
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