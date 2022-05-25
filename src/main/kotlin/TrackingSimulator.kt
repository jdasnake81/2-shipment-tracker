import kotlinx.coroutines.*
import updateStrategy.*
import java.io.File

class TrackingSimulator {
    companion object {
        var shipments = HashMap<String, Shipment>()
            private set
    }

    private val shipmentUpdateStrategies = mapOf<String, ShipmentUpdateStrategy>(
        Pair("created", CreatedUpdateStrategy()),
        Pair("shipped", ShippedUpdateStrategy()),
        Pair("location", NewLocationUpdateStrategy()),
        Pair("delayed", DelayedUpdateStrategy()),
        Pair("noteadded", NoteAddedUpdateStrategy()),
        Pair("lost", FinalUpdateStrategy()),
        Pair("canceled", FinalUpdateStrategy()),
        Pair("delivered", FinalUpdateStrategy()),
    )

    fun addShipment(shipment: Shipment){
        shipments.put(shipment.id, shipment)
    }

    fun updateShipment(attributes: List<String>){
        shipmentUpdateStrategies[attributes[0]] ?.createUpdate(attributes[0], attributes) ?: return
    }

    fun runSimulation() = CoroutineScope(Dispatchers.Main).launch {
        var updates = ArrayList<String>()
        File("test.txt").forEachLine {
            updates.add(it)
        }
        for (line in updates){
            delay(timeMillis = 1000)
            println(line)
            var shipment: Shipment?
            val updateParts = line.split(",")
            if (updateParts[0] == "created"){
                shipment = Shipment(updateParts)
                addShipment(shipment)
            } else {
                updateShipment(updateParts)
            }
        }
    }
}