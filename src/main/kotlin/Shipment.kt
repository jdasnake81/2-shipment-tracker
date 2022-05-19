class Shipment(val id: String, var status: String, var expectedDeliveryDateTimestamp: Long, var currentLocation: String) {
    var notes = ArrayList<String>()
    var updateHistory = ArrayList<ShippingUpdate>()

    init {
//        addUpdateHistory()
    }

    fun addNote(note: String){

    }

    fun addUpdateHistory(update: ShippingUpdate){

    }
}