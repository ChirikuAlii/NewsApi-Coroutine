package info.chirikualii.newsapi_coroutine.di

import android.content.Context
import com.google.gson.Gson
import info.chirikualii.newsapi_coroutine.data.local.NewsDb
import info.chirikualii.newsapi_coroutine.data.remote.ApiService
import info.chirikualii.newsapi_coroutine.data.remote.NetworkConnectionInterceptor
import info.chirikualii.newsapi_coroutine.data.repository.HeadlineRepo
import info.chirikualii.newsapi_coroutine.ui.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by chirikuAlii on 25/06/2020.
 * github.com/chirikualii
 */

val appModule = module {

    single { createOkHttpClient(androidContext()) }
    single { createRetrofit(get()) }
    single { createApiService(get()) }

    factory { HeadlineRepo(get(),get()) }

    viewModel { MainViewModel(get()) }
}

val dataModule = module {

    single { NewsDb.getInstance(get()) }

    single { get<NewsDb>().articleDao() }
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .client(okHttpClient)
        .build()

}

fun createOkHttpClient(context : Context): OkHttpClient {

    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .writeTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(NetworkConnectionInterceptor(context))
        .build()
}

fun createApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)