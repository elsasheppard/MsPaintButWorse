package com.example.mspaintbutworse

import android.content.ContentValues.TAG
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View


// @JvmOverloads after CustomView?
class CustomView constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    //drawing path
    private var drawPath: Path? = null

    //defines what to draw
    private var canvasPaint: Paint? = null

    //defines how to draw
    private var drawPaint: Paint? = null

    //initial color
    private val paintColor = -0x9a0000

    //canvas - holding pen, holds your drawings
    //and transfers them to the view
    private var drawCanvas: Canvas? = null

    //canvas bitmap
    private var canvasBitmap: Bitmap? = null

    //brush size
    private var currentBrushSize = 0f  //brush size
    private var lastBrushSize = 0f

    // this java code didn't auto format to kotlin???
    private fun initResources(){
        currentBrushSize = resources.getInteger(R.integer.medium_size).toFloat()
        lastBrushSize = currentBrushSize

        drawPath = Path()
        drawPaint = Paint().apply {
            color = paintColor
            isAntiAlias = true
            strokeWidth = currentBrushSize
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            setStrokeCap(Paint.Cap.ROUND)
        }

        canvasPaint = Paint(Paint.DITHER_FLAG)

    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        setWillNotDraw(false)


        initResources()

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

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        //create canvas of certain device size.
        super.onSizeChanged(w, h, oldw, oldh)

        //create Bitmap of certain w,h
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888) as Bitmap

        //apply bitmap to graphic to start drawing.
        drawCanvas = Canvas(canvasBitmap!!)
    }

    // was override fun onTouchEvent
    fun performClick(event: MotionEvent): Boolean {
        val touchX = event.x
        val touchY = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> drawPath!!.moveTo(touchX, touchY)
            MotionEvent.ACTION_MOVE -> drawPath!!.lineTo(touchX, touchY)
            MotionEvent.ACTION_UP -> {
                drawPath!!.lineTo(touchX, touchY)
                drawCanvas!!.drawPath(drawPath!!, drawPaint!!)
                drawPath!!.reset()
            }
            else -> return false
        }
        //redraw
        invalidate()
        return true
    }
}