package com.miu.aalemu.personal_cv

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     lateinit var fmanager: FragmentManager
     lateinit var tx: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val adapter = MyAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter = adapter


//        fmanager = supportFragmentManager
//        tx = fmanager.beginTransaction();
//        tx.add(R.id.frame_view, BlankFragment())

        TabLayoutMediator(tlayaout,viewpager){tab,position->
            when(position){
                0->{
                    tab.text="Home"
                    tab.setIcon(R.drawable.home)
                }
                1->{
                    tab.text="About Me"
                    tab.setIcon(R.drawable.about_me)
                }
                2->{
                tab.text="Work"
                tab.setIcon(R.drawable.work)
                }
                3->{
                    tab.text="Contact"
                    tab.setIcon(R.drawable.contact_me)
                }
            }
        }.attach()

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
//        val viewPager: ViewPager = binding.viewPager
//        viewPager.adapter = sectionsPagerAdapter
//        val tabs: TabLayout = binding.tabs
//        tabs.setupWithViewPager(viewPager)
//        val fab: FloatingActionButton = binding.fab
//
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }
}