package com.example.compose.textfield.bug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import com.example.compose.textfield.bug.ui.theme.ComposeTextFieldBugTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTextFieldBugTheme(false) {
                Column {
                    ContentExampleOne()
//                    ContentExampleTwo()
                }
            }
        }
    }
}
