import updateStrategy.*

class ShippingUpdate(attributes: List<String>) {

    val previousStatus?: String
    val newStatus : String
    val timestamp: Long

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


    }
}
