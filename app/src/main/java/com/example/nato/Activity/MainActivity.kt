package com.example.nato.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TableLayout
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.nato.Adapter.ViewPagerAdapter
import com.example.nato.Fragment.*
import com.example.nato.R
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private var viewPager: ViewPager? = null
    private var ivFilter: ImageView? = null
    var tabs: TabLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        defined();
        clickFilter()
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(OpportunityFragment(), "Opportunity")
        adapter.addFragment(CuriosityFragment(), "Curiosity")
        adapter.addFragment(SpritFragment(), "Split")

        viewPager?.adapter = adapter
        tabs?.setupWithViewPager(viewPager)

    }

    private fun clickFilter() {
        ivFilter?.setOnClickListener {
            val pop = FilterFragment()
            val fm = this@MainActivity.supportFragmentManager
            pop.show(fm, "filterDialog")
        }
    }

    private fun defined() {
        viewPager = findViewById<ViewPager>(R.id.viewPager)
        ivFilter = findViewById<ImageView>(R.id.ivFilter);
        tabs = findViewById<TabLayout>(R.id.tabs)
    }
}