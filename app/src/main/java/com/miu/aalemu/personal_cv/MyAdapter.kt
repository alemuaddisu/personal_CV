package com.miu.aalemu.personal_cv

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.miu.aalemu.personal_cv.ui.main.About
import com.miu.aalemu.personal_cv.ui.main.Contact
import com.miu.aalemu.personal_cv.ui.main.Home
import com.miu.aalemu.personal_cv.ui.main.Work

class MyAdapter (fm:FragmentManager, lc:Lifecycle): FragmentStateAdapter(fm,lc){
    override fun getItemCount() = 4
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }

    override fun createFragment(position: Int): Fragment {
      return  when(position) {
          3 -> Home()
          1 -> About()
          2 -> Work()
          0 -> Contact()
          else -> Fragment()
      }
    }

}
