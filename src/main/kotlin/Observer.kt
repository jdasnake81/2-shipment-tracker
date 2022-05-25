interface Observer {
    fun notifyUpdateAdded(updates: ArrayList<ShippingUpdate>)

    fun notifyNoteAdded(notes: ArrayList<String>)

    fun notifyStatusChanged(status: String)

    fun notifyETAChangeTimestamp(timestamp: Long)

    fun notifyLocationChange(location: String)

}