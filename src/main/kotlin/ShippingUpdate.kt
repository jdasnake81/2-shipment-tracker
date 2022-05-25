import updateStrategy.*

class ShippingUpdate(attributes: List<String>, val previousStatus: String?) {

    val newStatus : String
    val timestamp: Long

    init {
        newStatus = attributes[0]
        timestamp = attributes[2].toLong()
    }
}
