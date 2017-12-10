package com.github.ivanpetrov16130.androidstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    private fun mainForClasses() {

        val inlineAlert = object: Alertable() {

            override var shouldDisappearOnTap: Boolean = true

            public override fun show() { println("Inline alert did appeared") }

            public override fun hide() { println("Inline alert did disappeared") }

            protected override fun removeFromViewHierarchy() { println("Inline alert did removed from view hierarchy") }

        }

        println("Inline alert log")
        println(inlineAlert.isShowing)
        println(inlineAlert.alertMessage)
        println(inlineAlert.shouldDisappearOnTap)
        inlineAlert.show()
        inlineAlert.hide()



        val popupAlert = PopupNotification()

        println("Popup alert log")
        println(PopupNotification.Companion.reuseIdentifier)
        println(popupAlert.isShowing)
        println(popupAlert.alertMessage)
        println(popupAlert.closeMessage)
        println(popupAlert.shouldDisappearOnTap)
        popupAlert.show()
        popupAlert.hide()



        val cancelablePopupAlert = CancelablePopupNotification()
        println("Cancelable popup alert log")
        println(cancelablePopupAlert.isShowing)
        println(cancelablePopupAlert.alertMessage)
        println(cancelablePopupAlert.closeMessage)
        println(cancelablePopupAlert.cancelMessage)
        println(cancelablePopupAlert.shouldDisappearOnTap)
        println(cancelablePopupAlert.cancelButtonColor)

        cancelablePopupAlert.show()
        cancelablePopupAlert.cancel()

    }

    private fun mainForInterfaces() {

        val coder = Coder()
        val decoder = Decoder()


        val jsonRepresentation = JsonRepresentation()
        jsonRepresentation.decodeWith(decoder)
        jsonRepresentation.encodeWith(coder)


        val userProperty = UserProperty()
        userProperty.encodeWith(coder)
        userProperty.dispose()

        val token = Token()
        token.decodeWith(decoder)
        token.dispose()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainForClasses()
        mainForInterfaces()
    }
}
