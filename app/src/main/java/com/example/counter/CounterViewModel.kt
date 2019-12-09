package com.example.counter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//view model will persist eventhough the mainactivity is being destroyed
class CounterViewModel : ViewModel(){
    private val _counter = MutableLiveData<Int>()
    val counter : LiveData<Int>
        get() = _counter//getter

    init{
        Log.d("ViewModel", "ViewModel Initialised")
        _counter.value = 0
    }
    //write function to increment the counter
    fun increment(){
        //instead of using var, reinitialise the val
        _counter.value = _counter.value?.plus(1)
    }

    fun decrement(){
        _counter.value = _counter.value?.minus(1)
    }

    override fun onCleared() {
        Log.d("ViewModel", "ViewModel cleared")
        super.onCleared()
    }
}