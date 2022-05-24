package updateStrategy

import ShippingUpdate

interface ShipmentUpdateStrategy {
    fun createUpdate(updateType: String, updateData: List<String>): ShippingUpdate
}