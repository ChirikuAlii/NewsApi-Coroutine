package info.chirikualii.newsapi_coroutine

import android.app.Application
import info.chirikualii.newsapi_coroutine.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


/**
 * Created by chirikuAlii on 25/06/2020.
 * github.com/chirikualii
 */
class ApplicationLoader :Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationLoader)
            androidLogger()
            modules(listOf(appModule))
        }
    }
}