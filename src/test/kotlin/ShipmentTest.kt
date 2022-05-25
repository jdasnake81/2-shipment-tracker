import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShipmentTest {
    val input = "created,1234,1652712855"
    val update1 = "location,s10000,1652712855468,Los Angeles CA".split(",")
    val update2 = "shipped,s10000,1652712855468,1652713940874".split(",")
    var shipment = Shipment(input.split(","))
    val trackerSim = TrackingSimulator()
    init {
        trackerSim.addShipment(shipment)
    }

    @Test
    fun getStatus() {
        assertEquals("created", shipment.status)
    }

    @Test
    fun getId() {
        assertEquals("1234", shipment.id)
    }

    @Test
    fun getNotes() {
        var note = "this is a note"
        assertEquals(0, shipment.notes.size)
        shipment.addNote(note)
        assertEquals(1, shipment.notes.size)
        assertEquals(note, shipment.notes[0])
    }

    @Test
    fun getUpdateHistory() {
        assertEquals(1, shipment.updateHistory.size)
        shipment.addUpdateHistory(update1)
        assertEquals(2, shipment.updateHistory.size)
        shipment.addUpdateHistory(update2)
        assertEquals(3, shipment.updateHistory.size)
    }

    @Test
    fun getExpectedDeliveryDateTimestamp() {
        shipment.addUpdateHistory(update2)
        assertEquals(update2.last(), shipment.expectedDeliveryDateTimestamp)
    }

    @Test
    fun setExpectedDeliveryDateTimestamp() {
    }

    @Test
    fun getCurrentLocation() {
    }

    @Test
    fun setCurrentLocation() {
    }

    @Test
    fun addNote() {
    }

    @Test
    fun addUpdateHistory() {
    }

    @Test
    fun addObserver() {
    }

    @Test
    fun removeObserver() {
    }

    @Test
    fun notifyStatusChange() {
    }

    @Test
    fun notifyNoteAdded() {
    }

    @Test
    fun notifyUpdateAdded() {
    }

    @Test
    fun notifyETAChange() {
    }

    @Test
    fun notifyLocationChange() {
    }
}