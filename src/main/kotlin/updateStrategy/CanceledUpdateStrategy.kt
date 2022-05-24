package updateStrategy

import ShippingUpdate

class CanceledUpdateStrategy : ShipmentUpdateStrategy{
    override fun createUpdate(updateType: String, updateData: List<String>): ShippingUpdate {
        TODO("Not yet implemented")
    }
}