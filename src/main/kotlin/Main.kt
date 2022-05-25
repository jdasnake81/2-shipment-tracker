// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
fun ShipmentView(viewHelper: TrackerViewHelper, removeView: () -> Unit){
    Column(modifier = Modifier.fillMaxWidth()
        .border(BorderStroke(2.dp, Color.Black))) {
            if (viewHelper.verified) {
                Column {
                    Text("Tracking shipment ${viewHelper.shipmentID}", fontSize = 20.sp)
                    Column (modifier = Modifier.padding(5.dp)){
                        Text("Status: ${viewHelper.shipmentStatus}")
                        Text("Location: ${viewHelper.shipmentLocation}")
                        if (viewHelper.shipmentETA == 0L) {
                            Text("Expected Delivery: --")
                        } else {
                            Text("Expected Delivery: ${viewHelper.expectedDeliveryToDate()}")
                        }
                    }
                    Column (modifier = Modifier.padding(5.dp)) {
                        Text("Status Updates: ")
                        viewHelper.shipmentUpdateHistory.forEach {
                            if (it.statusChange) {
                                Text(it.toString())
                            }
                        }
                    }
                    Column (modifier = Modifier.padding(5.dp)) {
                        Text("Notes:")
                        viewHelper.shipmentNotes.forEach {
                            Text(it)
                        }
                    }
                }
        } else {
            Text("Shipment with ID ${viewHelper.shipmentID} not found")
        }
        Button(removeView) {
            Text("Stop Tracking")
        }
    }
}

@Composable
fun App() {
    val simulator = TrackingSimulator()
    simulator.runSimulation()
    val trackerViewHelpers = remember { mutableStateListOf<TrackerViewHelper>() }
    MaterialTheme {
        Column {
            Row (modifier = Modifier.fillMaxWidth()){
                val textState = remember { mutableStateOf("") }
                TextField(textState.value, {textState.value = it} )
                Button(onClick = {
                    val tracker = TrackerViewHelper()
                    tracker.trackShipment(textState.value)
                    trackerViewHelpers.add(tracker)
                }) {
                    Text("TRACK")
                }
            }
            LazyColumn {
                items(trackerViewHelpers) { trackerViewHelper ->
                    ShipmentView(trackerViewHelper) {
                        trackerViewHelpers.remove(trackerViewHelper)
                        trackerViewHelper.stopTracking()
                    }
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
