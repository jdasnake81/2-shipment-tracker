import updateStrategy.*

class Shipment(initialAttributes: List<String>) {
    var status: String
//        private set
    val id: String
    var notes = ArrayList<String>()
    var updateHistory = ArrayList<ShippingUpdate>()
    var expectedDeliveryDateTimestamp: Long
    var currentLocation: String

    init {

        status = initialAttributes[0]
        id = initialAttributes[1]
        expectedDeliveryDateTimestamp = 0
        currentLocation = ""
        addUpdateHistory(initialAttributes)
    }

    fun addNote(note: String){
        notes.add(note)
    }

    fun addUpdateHistory(attributes: List<String>){
        val update = ShippingUpdate(attributes, status)
        updateHistory.add(update)
    }
}