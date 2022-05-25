// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.CoroutineScope

@Composable
fun ShipmentView(viewHelper: TrackerViewHelper){
    Column {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Column {
                Text("Shipment info goes here")
            }
            Button(onClick = {
                viewHelper.stopTracking()
            }) {
                Text("Stop Tracking")
            }
        }
    }

}

@Composable
@Preview
fun App() {
    val trackerViewHelpers = remember { mutableStateListOf<TrackerViewHelper>() }
    MaterialTheme {
        val coroutineScope = rememberCoroutineScope()
        Column {
            Row {
                val textState = remember { mutableStateOf(TextFieldValue()) }
                TextField(textState.value, {textState.value = it} )
                Button(onClick = {
                    trackerViewHelpers.add(TrackerViewHelper(textState.toString()))
                }) {
                    Text("TRACK")
                }
            }
            LazyColumn {
                items(trackerViewHelpers) { trackerViewHelper ->
                    ShipmentView(trackerViewHelper)
                }
            }
//            ShipmentView(TrackerViewHelper(), rememberCoroutineScope())
//            ShipmentView(TrackerViewHelper(), rememberCoroutineScope())
//            ShipmentView(TrackerViewHelper(), rememberCoroutineScope())
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
