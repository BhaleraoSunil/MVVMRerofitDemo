package com.example.mvvmrerofitdemo.models

import androidx.room.Entity
import androidx.room.Ignore

@Entity(tableName = "quote")
data class Result(
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    @Ignore
    val tags: List<String>
)