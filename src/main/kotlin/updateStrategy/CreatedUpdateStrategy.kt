package updateStrategy

import Shipment

class CreatedUpdateStrategy : ShipmentUpdateStrategy {
    override fun createUpdate(updateType: String, updateData: List<String>) {
        val shipment = Shipment(updateData)
        shipment.addUpdateHistory(updateData)
    }
}