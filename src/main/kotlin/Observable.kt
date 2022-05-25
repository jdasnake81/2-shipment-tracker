interface Observable {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyStatusChange()
    fun notifyUpdateAdded()
    fun notifyNoteAdded()
    fun notifyETAChange()
    fun notifyLocationChange()
}