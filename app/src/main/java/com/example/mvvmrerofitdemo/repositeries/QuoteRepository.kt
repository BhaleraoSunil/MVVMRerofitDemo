package com.example.mvvmrerofitdemo.repositeries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmrerofitdemo.api.QuoteService
import com.example.mvvmrerofitdemo.db.QuoteDatabase
import com.example.mvvmrerofitdemo.models.QuoteList

class QuoteRepository(private val quoteService: QuoteService,private val quoteDatabase: QuoteDatabase) {


    private val  quotesLiveData = MutableLiveData<QuoteList>()

    val quotes : LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun  getQuotes(page:Int){

        val result = quoteService.getQuotes(page)

        if(result.body() != null){

            quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
            quotesLiveData.postValue(result.body())
        }

    }


}