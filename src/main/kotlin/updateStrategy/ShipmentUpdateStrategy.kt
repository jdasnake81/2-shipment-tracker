package updateStrategy

interface ShipmentUpdateStrategy {
    fun createUpdate(updateType: String, updateData: ArrayList<String>)
}