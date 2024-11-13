package com.example.date_picker_native

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import io.flutter.plugin.platform.PlatformView
import androidx.compose.material3.ExperimentalMaterial3Api
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
internal class DatePickerPlatformView(context: Context, id: Int, creationParams:  Map<*, *>?) : PlatformView, ActivityPluginBinding.OnSaveInstanceStateListener{

    private var composeView : ComposeView

    override fun getView(): View {
        return  composeView
    }

    override fun dispose() {
    }

    init {
        composeView = ComposeView(context)
        composeView.id = id
        composeView.setContent {
            var showDatePicker by remember { mutableStateOf(false) }
            val datePickerState = rememberDatePickerState()
            val selectedDate = datePickerState.selectedDateMillis?.let {
                convertMillisToDate(it)
            } ?: ""

            Box(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                OutlinedTextField(
                    value = selectedDate,
                    onValueChange = { },
                    label = { Text("DOB") },
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { showDatePicker = !showDatePicker }) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Select date"
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                )

                if (showDatePicker) {
                    Popup(
                        onDismissRequest = { showDatePicker = false },
                        alignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y = 64.dp)
                                .shadow(elevation = 4.dp)
                                .background(MaterialTheme.colorScheme.surface)
                                .padding(16.dp)
                        ) {
                            DatePicker(
                                state = datePickerState,
                                showModeToggle = false
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(bundle: Bundle) {
    }

    override fun onRestoreInstanceState(bundle: Bundle?) {
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

