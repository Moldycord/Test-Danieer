package com.example.myapplication.presentation.views

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.myapplication.R


@Composable
fun ErrorDialog(
    message: String,
    onRetry: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.error_label)) },
        text = { Text(message) },
        confirmButton = {
            TextButton(onClick = {
                onRetry()
            }) {
                Text(stringResource(R.string.retry_label))
            }
        }
    )
}