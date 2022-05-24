package updateStrategy

import ShippingUpdate
import TrackingSimulator

class DelayedUpdateStrategy : ShipmentUpdateStrategy {
    override fun createUpdate(updateType: String, updateData: List<String>) {
        val shipment = TrackingSimulator.shipments.get(updateData[1])
        val update = ShippingUpdate(updateData)
        if (shipment != null) {
            shipment.status = updateData[0]
            shipment.expectedDeliveryDateTimestamp = updateData.last().toLong()
            shipment.addUpdateHistory(update)
        }
    }
}