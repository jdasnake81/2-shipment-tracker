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
        val createdUpdate = ShippingUpdate()
//        addUpdateHistory()
    }

    fun addNote(note: String){

    }

    fun addUpdateHistory(update: ShippingUpdate){

    }
}