package com.github.ivanpetrov16130.androidstudy

import android.graphics.Color


abstract class Alertable(val alertMessage: String = "Something wrong!") {

    abstract var shouldDisappearOnTap: Boolean


    internal abstract fun show()

    internal abstract fun hide()

    protected abstract fun removeFromViewHierarchy()

    internal val isShowing: Boolean get() = true

    private var timeIntervalToBeDisposed: Double? = 1000.0

    protected val isAutodisposable: Boolean get() { return timeIntervalToBeDisposed?.run {  true } ?: false  }

}


open class PopupNotification(val closeMessage: String = "OK", override var shouldDisappearOnTap: Boolean = true): Alertable(alertMessage = "OK?") {

    companion object { @JvmStatic public val reuseIdentifier: String get() = this.javaClass.name }

    public override fun show() { println("Popup did appeared") }

    public override fun hide() { println("Popup did disappeared") }

    protected override fun removeFromViewHierarchy() { println("Popup did removed from view hierarchy") }

}


class CancelablePopupNotification(val cancelMessage: String = "Cancel", val cancelHandler: (() -> Unit)? = null): PopupNotification(closeMessage = "OK", shouldDisappearOnTap = false) {

    var cancelButtonColor: Color = Color()

    internal fun cancel() {
        cancelHandler?.invoke()
        hide()
    }

}