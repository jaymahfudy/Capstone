package com.floriv.capstone

import android.app.Application
import com.floriv.capstone.core.di.databaseModule
import com.floriv.capstone.core.di.networkModule
import com.floriv.capstone.core.di.repositoryModule
import com.floriv.capstone.di.useCaseModule
import com.floriv.capstone.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
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
}