
class Shipment(initialAttributes: List<String>): Observable {
    var status: String = initialAttributes[0]
        set(value) {
            field = value
            notifyStatusChange()
        }

    val id: String

    var notes = ArrayList<String>()

    var updateHistory = ArrayList<ShippingUpdate>()

    var expectedDeliveryDateTimestamp: Long = 0
        set(value) {
            field = value
            notifyETAChange()
        }

    var currentLocation: String = ""
        set(value) {
            field = value
            notifyLocationChange()
        }

    private val observers = mutableListOf<Observer>()

    init {
        status = initialAttributes[0]
        id = initialAttributes[1]
        expectedDeliveryDateTimestamp = 0
        currentLocation = ""
        addUpdateHistory(initialAttributes)
    }

    fun addNote(note: String){
        notes.add(note)
        notifyNoteAdded()
    }

    fun addUpdateHistory(attributes: List<String>){
        val update = ShippingUpdate(attributes, status)
        updateHistory.add(update)
        notifyUpdateAdded()
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyStatusChange() {
        observers.forEach { it.notifyStatusChanged(status)}
    }

    override fun notifyNoteAdded() {
        observers.forEach { it.notifyNoteAdded(notes)}
    }

    override fun notifyUpdateAdded() {
        observers.forEach { it.notifyUpdateAdded(updateHistory)}
    }

    override fun notifyETAChange() {
        observers.forEach { it.notifyETAChangeTimestamp(expectedDeliveryDateTimestamp)}
    }

    override fun notifyLocationChange() {
        observers.forEach { it.notifyLocationChange(currentLocation)}
    }
}