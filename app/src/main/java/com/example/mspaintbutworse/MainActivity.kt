package com.example.mspaintbutworse

import android.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private var mtoolbarTop: Toolbar? = null
    private var mtoolbarBottom: Toolbar? = null
    private var mFab: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item) // this was activity_main before in full red

        mtoolbarTop = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(mtoolbarTop)

        mtoolbarBottom = findViewById<View>(R.id.toolbarBottom) as Toolbar
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
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return super.onOptionsItemSelected(item)
    }
}