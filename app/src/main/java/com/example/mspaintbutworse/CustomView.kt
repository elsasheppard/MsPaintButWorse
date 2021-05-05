package com.example.mspaintbutworse

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

// @JvmOverloads after CustomView?
class CustomView constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        setWillNotDraw(false)

        paint = Paint().apply {
            isAntiAlias = true
            color = Color.RED
            style = Paint.Style.FILL
        }
    }

    lateinit var paint: Paint

    // Called when the view should render its content.
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.d(TAG, "onDraw: it worked")
        // DRAW STUFF HERE
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)


        canvas.drawCircle(100f, 100f, 100f, paint)

/*  examples of canvas usages
        canvas.drawBitmap(bitmap, null, rect, paint)

        canvas.drawCircle(x, y, size, paint)

        canvas.drawRect(rect, paint)


    }
*/
}

}