package com.github.ivanpetrov16130.androidstudy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk21.coroutines.*

class MainActivityLayout: AnkoComponent<MainActivity> {


    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        scrollView { verticalLayout {
            val closeButton = imageButton(R.drawable.expand_arrow) {
                onClick { Log.d("CLOSE TAP", "CLOSE TAP") }// print("Close button tap") }
            }.lparams(width = 45, height = 45) {
                horizontalGravity = Gravity.CENTER_HORIZONTAL
                verticalMargin = dip(16)
            }
            val coverImageView = imageView(R.drawable.der_fuhrer).lparams(width = wrapContent, height = wrapContent) {
                horizontalGravity = Gravity.CENTER_HORIZONTAL
                verticalGravity = Gravity.TOP
            }
            val songProgress = seekBar().lparams {
                verticalMargin = dip(8)
            }
            val songTitle = textView("Сalling for signatures 32hours compilation") {
                textSize = 19f
            }.lparams{
                horizontalGravity = Gravity.CENTER_HORIZONTAL
                verticalMargin = dip(16)
x            }
            val artistName = textView("Navalny Alexei"){
                textSize = 17f
            }.lparams{
                horizontalGravity = Gravity.CENTER_HORIZONTAL
                verticalMargin = dip(8)

            }
            linearLayout {
                val previousTrackButton = imageButton(R.drawable.prev_icon) {
                    onClick { print("Previous track button tap") }
                }
                val pauseButton = imageButton(R.drawable.pause_icon) {
                    onClick { print("Pause button tap") }
                }
                val nextButton = imageButton(R.drawable.next_icon) {
                    onClick { print("Next track button tap") }
                }
            }.lparams{
                horizontalGravity = Gravity.CENTER_HORIZONTAL
                verticalMargin = dip(16)

            }
            linearLayout {
                val volumeMinimizerIcon = imageView()
                val volumeRegulator = seekBar().lparams {
                    verticalMargin = dip(8)
                }
                val volumeMaximizerIcon = imageView()
            }.lparams{
                horizontalGravity = Gravity.CENTER_HORIZONTAL
                verticalMargin = dip(16)
            }
            linearLayout {
                val addButton = button("Add") {
                    onClick { print("Add button tap") }
                }
                val someButton = button("Some") {
                    onClick { print("Some button tap") }
                }
                val moreButton = button("More") {
                    onClick { print("More button tap") }
                }
            }.lparams{
                horizontalGravity = Gravity.CENTER_HORIZONTAL
                verticalMargin = dip(24)

            }
        } }

    }
}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityLayout().setContentView(this)

    }
}
