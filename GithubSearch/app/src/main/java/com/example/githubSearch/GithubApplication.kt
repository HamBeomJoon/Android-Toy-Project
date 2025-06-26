package com.example.githubSearch

import android.app.Application
import com.example.githubSearch.di.DatabaseModule

class GithubApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseModule.init(this)
    }
}
