package com.example.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposebasic.ui.theme.JetpackComposeMasterTheme
import com.example.jetpackcomposebasic.viewmodel.QuoteViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMasterTheme {

                val viewModel by viewModels<QuoteViewModel>()
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {

                    DefaultPreview(viewModel)
                }
            }
        }
    }
}

@Composable
fun DefaultPreview(viewModel: QuoteViewModel) {
    val loader = viewModel.loading
    val dataList = viewModel.dataList
    var scope  = rememberCoroutineScope()

    Column(verticalArrangement = Arrangement.Center) {
        
        TextButton(onClick = {
            scope.launch {
                viewModel.getQuotes()
            }
        }) {
            Text(text = "Get Data")
        }
        
        
        if (dataList.size == 0|| loader) {
            CircularProgressIndicator()
        } else {
            for (data in dataList) {
                Text(text = data, color = Color.Black)
            }
        }

    }

}