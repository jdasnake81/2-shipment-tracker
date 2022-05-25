import updateStrategy.*
import java.util.Date

class ShippingUpdate(attributes: List<String>, private val previousStatus: String) {

    private val newStatus : String
    private val timestamp: Long
    val statusChange: Boolean


    init {
        newStatus = attributes[0]
        timestamp = attributes[2].toLong()
//        statusChange = true
        statusChange = previousStatus != newStatus
    }

    override fun toString(): String {
        return "Shipment went from $previousStatus to $newStatus at ${Date(timestamp)}"
    }
}
