import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class TrackerViewHelper(var id: String?): Observer{
    var shipmentID = id
    val shipment = trackShipment(id)
    var shipmentNotes by mutableStateOf(shipment.notes)
    var shipmentUpdateHistory by  mutableStateOf(shipment.updateHistory)
    var shipmentETA by mutableStateOf(shipment.expectedDeliveryDateTimestamp)
    var shipmentStatus by mutableStateOf(shipment.status)
    var shipmentLocation by mutableStateOf(shipment.currentLocation)

    init {
        shipment.addObserver(this)
    }

    override fun notifyUpdateAdded(updates: ArrayList<ShippingUpdate>) {
        this.shipmentUpdateHistory = updates
    }

    override fun notifyNoteAdded(notes: ArrayList<String>) {
        this.shipmentNotes = notes
    }

    override fun notifyStatusChanged(status: String) {
        this.shipmentStatus = status
    }

    override fun notifyETAChangeTimestamp(timestamp: Long) {
        this.shipmentETA = timestamp
    }

    override fun notifyLocationChange(location: String) {
        this.shipmentLocation = location
    }

    fun trackShipment(id: String?): Shipment{
        val shipment = TrackingSimulator.shipments[id]
        return shipment
    }

    fun stopTracking(){
        shipment.removeObserver(this)
    }

}