package com.example.compose.textfield.bug

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.Executors

// Example 2
private val viewModel = ExampleTwoViewModel()

@Composable
fun ContentExampleTwo() {
    SimpleTextField(
        text = viewModel.text.observeAsState("").value,
        onValueChange = viewModel::input
    )
}

@Composable
private fun SimpleTextField(text: String, onValueChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth()
    )
}

private class ExampleTwoViewModel {
    private var _text = MutableLiveData<String>()

    val text: LiveData<String>
        get() = _text


    private val executor = Executors.newSingleThreadExecutor()

    fun input(s: String) {
        executor.execute {
            _text.postValue(s)
        }
    }
}