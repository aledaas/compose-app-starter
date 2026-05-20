package com.aledaas.compose_app_starter.core.layout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String
) {
    LargeTopAppBar(
        title = {
            Text(text = title)
        }
    )
}