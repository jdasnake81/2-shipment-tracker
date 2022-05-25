import updateStrategy.*

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

    fun findShipment(id: String): Shipment? {
        return shipments.get(id)
    }

    fun addShipment(shipment: Shipment){
        shipments.put(shipment.id, shipment)
    }

    fun updateShipment(attributes: List<String>){
        val shipment = shipmentUpdateStrategies[attributes[0]] ?.createUpdate(attributes[0], attributes) ?: return
    }

    fun runSimulation(){
        TODO("Implement coroutine to run simulator")
        TODO("Feed file input into Shipment class to create/update shipment")
        var fileInput = ""
        val updateParts = fileInput.split(",")
        if (updateParts[0] == "created"){
            var shipment = Shipment(updateParts)
        }
    }

}