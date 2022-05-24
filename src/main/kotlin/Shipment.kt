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
//        addUpdateHistory(initialAttributes)
//        addUpdateHistory()
    }

    fun addNote(note: String){

    }

    fun addUpdateHistory(update: List<String>){
        TODO("Parse data to create update object and add to updateHistory")
    }
}