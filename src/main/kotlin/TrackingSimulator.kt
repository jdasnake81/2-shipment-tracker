class TrackingSimulator {
    var shipments = HashMap<String, Shipment>()
        private set

    fun findShipment(id: String): Shipment? {
        return shipments.get(id)
    }

    fun addShipment(shipment: Shipment){
        shipments.put(shipment.id, shipment)
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