package com.example.mvvmrerofitdemo.db

import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmrerofitdemo.models.Result

interface QuoteDao {

    @Insert
    suspend fun  addQuotes(list: List<Result>)

    @Query("select * from quote")
    suspend fun  getQuotes():List<Result>

}