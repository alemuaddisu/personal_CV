package com.miu.aalemu.personal_cv.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.miu.aalemu.personal_cv.R
import com.miu.aalemu.personal_cv.data.CommonData

class RecyclerAdapter(private val commonDataList:List<CommonData>, private val ind: Int): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.reusable_layout, viewGroup, false)
 return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = commonDataList.filter{it.type==ind}.get(i).title
        viewHolder.itemDetail.text = commonDataList.filter{it.type==ind}.get(i).detail
        viewHolder.itemFooter.text = commonDataList.filter{it.type==ind}.get(i).footer

    }

    override fun getItemCount(): Int {
        return commonDataList.filter{it.type==ind}.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTitle: TextView
        var itemDetail: TextView
        var itemFooter: TextView

        init {
            itemTitle = itemView.findViewById(R.id.titleView)
            itemDetail = itemView.findViewById(R.id.detailView)
            itemFooter = itemView.findViewById(R.id.footerView)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context
//                val intent = Intent(context, DetailPertanyaan::class.java).apply {
//                    putExtra("NUMBER", position)
//                    putExtra("CODE", itemKode.text)
//                    putExtra("CATEGORY", itemKategori.text)
//                    putExtra("CONTENT", itemIsi.text)
//                }
//                context.startActivity(intent)
            }
        }
    }
}