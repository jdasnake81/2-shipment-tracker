package updateStrategy

class FinalUpdateStrategy : ShipmentUpdateStrategy {
    override fun createUpdate(updateType: String, updateData: List<String>) {
        val shipment = TrackingSimulator.shipments.get(updateData[1])
        if (shipment != null) {
            shipment.addUpdateHistory(updateData)
            shipment.status = updateData[0]
        }
    }

}