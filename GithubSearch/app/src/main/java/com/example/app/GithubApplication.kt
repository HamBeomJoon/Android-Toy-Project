package com.example.app

import android.app.Application
import com.example.app.di.DatabaseModule

class GithubApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseModule.init(this)
    }
}
