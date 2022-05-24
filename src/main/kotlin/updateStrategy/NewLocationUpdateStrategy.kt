package updateStrategy

import ShippingUpdate

class NewLocationUpdateStrategy : ShipmentUpdateStrategy {
    override fun createUpdate(updateType: String, updateData: List<String>) {
        val shipment = TrackingSimulator.shipments.get(updateData[1])
        if (shipment != null) {
            shipment.status = updateData[0]
            shipment.currentLocation = updateData.last()
            shipment.addUpdateHistory(updateData)
        }
    }
}