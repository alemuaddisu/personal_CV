package com.miu.aalemu.personal_cv

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_contact.*


class MainActivity : AppCompatActivity() {

    lateinit var fmanager: FragmentManager
    lateinit var tx: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val adapter = MyAdapter(supportFragmentManager, lifecycle)
        viewpager.adapter = adapter

        toolbar.setOnClickListener(object:View.OnClickListener{
            override fun onClick(view:View) {
                // Initialize a new instance of popup menu with the UI Component
                val popupMenu = PopupMenu(this@MainActivity.applicationContext, toolbar)
//             Inflate the popup menu
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu())

//                popupMenu.setOnMenuItemClickListener( object:PopupMenu.OnMenuItemClickListener {
//                    override fun onMenuItemClick(menuItem:MenuItem): Boolean {
//                        when (menuItem.getItemId()) {
//                        // Handle the menu items here
////                        R.id.m11 -> {
////// Set the text color to red tv.setTextColor(Color.RED)
////                          return true
////                        }
//                        R.id.m1 -> {
//                            toolbar.title ="the were title"
//                        return true }
////                        R.id.m21 -> {
////// Set the text color to blue
////                            toolbar.title ="the title"
////                            return true
////                    }
//                        else -> return false
//                    } }
//                     })
                popupMenu.show()
            }
        }
        )


        TabLayoutMediator(tlayaout, viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Home"
                    tab.setIcon(R.drawable.home)
                }
                1 -> {
                    tab.text = "About Me"
                    tab.setIcon(R.drawable.about_me)
                }
                2 -> {
                    tab.text = "Work"
                    tab.setIcon(R.drawable.work)
                }
                3 -> {
                    tab.text = "Contact"
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(applicationContext, "$item menu selected", Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }

    fun navigate(view: View) {
        val imgView: ImageView = view as ImageView;
//        webView.loadUrl("https://www.google.com")
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl("" + imgView.contentDescription)
    }
}