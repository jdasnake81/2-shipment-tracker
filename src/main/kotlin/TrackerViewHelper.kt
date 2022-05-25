import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.*
import kotlin.collections.ArrayList

class TrackerViewHelper: Observer{
    var shipmentID by mutableStateOf("")
        private set
    var shipmentNotes by mutableStateOf(ArrayList<String>())
        private set
    var shipmentUpdateHistory by  mutableStateOf(ArrayList<ShippingUpdate>())
        private set
    var shipmentETA by mutableStateOf(0L)
        private set
    var shipmentStatus by mutableStateOf("")
        private set
    var shipmentLocation by mutableStateOf("Unknown")
        private set
    var verified = true
        private set

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

    fun expectedDeliveryToDate(): Date {
        return Date(shipmentETA)
    }

    override fun notifyLocationChange(location: String) {
        this.shipmentLocation = location
    }

    fun trackShipment(id: String){
        val shipment = TrackingSimulator.shipments[id]
        if (shipment != null) {
            shipment.addObserver(this)
            shipmentID = shipment.id
            shipmentNotes = shipment.notes
            shipmentUpdateHistory = shipment.updateHistory
            shipmentETA = shipment.expectedDeliveryDateTimestamp
            shipmentStatus = shipment.status
            shipmentLocation = shipment.currentLocation
        }
        else verified = false
    }

    fun stopTracking() {
        TrackingSimulator.shipments[shipmentID]?.removeObserver(this)
    }

}