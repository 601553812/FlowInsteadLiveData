package com.pxh.flowinsteadlivedata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pxh.flowinsteadlivedata.ui.theme.FlowInsteadLiveDataTheme


class MainActivity : ComponentActivity() {
    val myViewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            FlowInsteadLiveDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(myViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(myViewModel: MyViewModel) {

    val value by myViewModel.nameFlow.collectAsState(initial = "")
    Text(text = "Hello ${value}!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FlowInsteadLiveDataTheme {
        Greeting(MyViewModel())
    }
}