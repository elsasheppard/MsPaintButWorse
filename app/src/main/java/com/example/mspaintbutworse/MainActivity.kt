package com.example.mspaintbutworse

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private var mtoolbarBottom: Toolbar? = null
    private var mFab: FloatingActionButton? = null
    private var canvas: CustomView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // this was activity_main before in full red

        canvas = findViewById(R.id.canvas_main)
        mtoolbarBottom = findViewById<View>(R.id.toolbar_bottom) as Toolbar
        mtoolbarBottom!!.inflateMenu(R.menu.menu_drawing)
        mtoolbarBottom!!.setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener { item ->
            handleDrawingIconTouched(item.itemId)
            false
        })

        mFab = findViewById<View>(R.id.fab) as FloatingActionButton
        mFab!!.setOnClickListener {
            mtoolbarBottom!!.setVisibility(View.VISIBLE)
            mFab!!.visibility = View.GONE
        }
    }

    private fun handleDrawingIconTouched(itemId: Int) {
        when (itemId) {
            R.id.action_brush -> {
                canvas?.setOnTouchListener { view, motionEvent ->
                    canvas?.performClick(motionEvent)!!
                    
                }
            }
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//        return super.onOptionsItemSelected(item)
//    }
}