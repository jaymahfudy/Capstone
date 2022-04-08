package com.floriv.capstone

import android.content.Context
import com.floriv.capstone.core.di.databaseModule
import com.floriv.capstone.core.di.networkModule
import com.floriv.capstone.core.di.repositoryModule
import com.floriv.capstone.di.useCaseModule
import com.floriv.capstone.di.viewModelModule
import com.google.android.play.core.splitcompat.SplitCompat
import com.google.android.play.core.splitcompat.SplitCompatApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class MyApplication : SplitCompatApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}