package com.miu.aalemu.personal_cv

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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