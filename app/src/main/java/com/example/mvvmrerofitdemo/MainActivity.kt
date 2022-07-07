package com.example.mvvmrerofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmrerofitdemo.api.QuoteService
import com.example.mvvmrerofitdemo.api.RetrofitHelper
import com.example.mvvmrerofitdemo.repositeries.QuoteRepository
import com.example.mvvmrerofitdemo.viewmodels.MainViewModel
import com.example.mvvmrerofitdemo.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var  mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        //val respository =  QuoteRepository(quoteService)

        val respository =  (application as QuoteApplication).respository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(respository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, {

           Log.e(javaClass.name,"quotes size---> ${it.results.size}")
            Log.e(javaClass.name,"quotes---> ${it.results.toString()}")
        })
    }
}