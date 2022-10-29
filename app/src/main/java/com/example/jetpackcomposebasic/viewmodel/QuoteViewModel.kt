package com.example.jetpackcomposebasic.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.jetpackcomposebasic.repository.Repository

class QuoteViewModel : ViewModel() {

    val dataRepo = Repository()
    var loading by mutableStateOf(false)
    var dataList by mutableStateOf(ArrayList<String>())


    suspend fun getQuotes() {
        changeLoading()
        dataList = dataRepo.getData()
        changeLoading()
    }

    private fun changeLoading() {
        loading = !loading
    }
}