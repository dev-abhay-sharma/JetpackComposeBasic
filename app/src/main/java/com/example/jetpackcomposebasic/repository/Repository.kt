package com.example.jetpackcomposebasic.repository

import kotlinx.coroutines.delay

class Repository {
    suspend fun getData(): ArrayList<String> {
        val tempList = arrayListOf<String>("Apple","Mango","Banana","Grapes")
        delay(1000)
        return tempList
    }
}