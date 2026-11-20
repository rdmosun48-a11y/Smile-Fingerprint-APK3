package com.smile.fingerprint

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.animation.OvershootInterpolator

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.BLACK
        window.navigationBarColor = Color.BLACK

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setBackgroundColor(Color.BLACK)
        }

        val title = TextView(this).apply {
            text = "😊"
            textSize = 100f
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Smile Fingerprint Animation"
            textSize = 22f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val button = TextView(this).apply {
            text = "TAP TO ANIMATE"
            textSize = 18f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            setPadding(40, 30, 40, 30)
        }

        button.setOnClickListener {
            val animation = ObjectAnimator.ofPropertyValuesHolder(
                title,
                PropertyValuesHolder.ofFloat(View.SCALE_X, 1f, 1.4f, 1f),
                PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f, 1.4f, 1f)
            )
            animation.duration = 700
            animation.repeatCount = 2
            animation.interpolator = OvershootInterpolator()
            animation.start()
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(button)

        setContentView(layout)
    }
}
