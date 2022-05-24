import updateStrategy.*

class Shipment(initialAttributes: List<String>) {
    var status: String
    val id: String
    var notes = ArrayList<String>()
    var updateHistory = ArrayList<ShippingUpdate>()
    var expectedDeliveryDateTimestamp: Long
    var currentLocation: String
    private val shipmentUpdateStrategies = mapOf<String, ShipmentUpdateStrategy>(
        Pair("shipped", ShippedUpdateStrategy()),
        Pair("location", NewLocationUpdateStrategy()),
        Pair("delayed", DelayedUpdateStrategy()),
        Pair("noteadded", NoteAddedUpdateStrategy()),
        Pair("lost", LostUpdateStrategy()),
        Pair("canceled", CanceledUpdateStrategy()),
        Pair("delivered", DeliveredUpdateStrategy()),
    )

    init {
        status = initialAttributes[0]
        id = initialAttributes[1]
        addUpdateHistory(initialAttributes)
//        addUpdateHistory()
    }

    fun addNote(note: String){

    }

    fun addUpdateHistory(update: List<String>){
        val update = shipmentUpdateStrategies[update[0]] ?.createUpdate(update[0], update) ?: return
        updateHistory.add(update)
    }
}