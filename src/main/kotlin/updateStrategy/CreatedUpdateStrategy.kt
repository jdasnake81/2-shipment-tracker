package updateStrategy

import Shipment

class CreatedUpdateStrategy : ShipmentUpdateStrategy {
    override fun createUpdate(updateType: String, updateData: List<String>) {
        val shipment = Shipment(updateData)
        shipment.status = updateData[0]
        shipment.addUpdateHistory(updateData)
    }
}