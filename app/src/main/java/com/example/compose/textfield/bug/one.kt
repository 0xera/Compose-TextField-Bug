package com.example.compose.textfield.bug

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import java.util.concurrent.Executors

// Example 1
private val viewModel = ExampleOneViewModel()

@Composable
fun ContentExampleOne() {
    SimpleTextField(text = viewModel.text, onValueChange = viewModel::input)
}

@Composable
private fun SimpleTextField(text: String, onValueChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth()
    )
}

private class ExampleOneViewModel {
    private var _text by mutableStateOf("")

    val text: String
        get() = _text


    private val executor = Executors.newSingleThreadExecutor()
    private val mainHandler = Handler(Looper.getMainLooper())

    fun input(s: String) {
        executor.execute {
            mainHandler.post { _text = s }
        }
    }
}