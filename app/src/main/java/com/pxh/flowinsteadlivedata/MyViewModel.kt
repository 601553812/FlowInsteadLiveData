package com.pxh.flowinsteadlivedata

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MyViewModel : ViewModel() {
    val nameFlow: Flow<String> = flow {
        var i = 0
        while (true) {
            i++
            kotlinx.coroutines.delay(100)
            emit("$i")
        }
    }.flowOn(Dispatchers.Default)

}