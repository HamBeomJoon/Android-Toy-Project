package com.example.app.di

import android.content.Context
import com.example.app.data.database.RecentKeywordDao
import com.example.app.data.database.RecentKeywordDatabase

object DatabaseModule {
    private lateinit var appContext: Context
    private const val ERROR_APP_CONTEXT_NOT_INITIALIZE = "appContext가 초기화되지 않았습니다."

    fun init(context: Context) {
        appContext = context.applicationContext
    }

    private val database: RecentKeywordDatabase by lazy {
        check(::appContext.isInitialized) { ERROR_APP_CONTEXT_NOT_INITIALIZE }
        RecentKeywordDatabase.getInstance(appContext)
    }

    val recentKeywordDao: RecentKeywordDao by lazy {
        database.recentKeywordDao()
    }
}
