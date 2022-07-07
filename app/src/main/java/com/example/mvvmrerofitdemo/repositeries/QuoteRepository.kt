package com.example.mvvmrerofitdemo.repositeries

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmrerofitdemo.api.NetworkUtils
import com.example.mvvmrerofitdemo.api.QuoteService
import com.example.mvvmrerofitdemo.db.QuoteDatabase
import com.example.mvvmrerofitdemo.models.QuoteList

class QuoteRepository(private val quoteService: QuoteService, private val quoteDatabase: QuoteDatabase,
                      private val appContext: Context
) {


    private val  quotesLiveData = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun  getQuotes(page:Int){

        if(NetworkUtils.isInternetAvailable(appContext)){
            val result = quoteService.getQuotes(page)
            if(result.body() != null){
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }

        }else{
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quotesList = QuoteList(1,1,1,quotes,1,1)
            quotesLiveData.postValue(quotesList)
        }
    }


}