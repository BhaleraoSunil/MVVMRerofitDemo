package com.example.mvvmrerofitdemo

import android.app.Application
import com.example.mvvmrerofitdemo.api.QuoteService
import com.example.mvvmrerofitdemo.api.RetrofitHelper
import com.example.mvvmrerofitdemo.db.QuoteDatabase
import com.example.mvvmrerofitdemo.repositeries.QuoteRepository

class QuoteApplication:Application() {

    lateinit var respository: QuoteRepository

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)


        val database = QuoteDatabase.getDatabase(applicationContext)

        respository =  QuoteRepository(quoteService,database, appContext = applicationContext)

    }
}