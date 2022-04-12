package com.miu.aalemu.personal_cv.ui.main

import android.content.Context
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miu.aalemu.personal_cv.R
import com.miu.aalemu.personal_cv.data.CommonData
import com.miu.aalemu.personal_cv.databinding.LayoutDialogueBinding
import com.miu.aalemu.personal_cv.util.getDataFromJson
import com.miu.aalemu.personal_cv.util.getJsonDataFromAsset
import kotlinx.android.synthetic.main.fragment_work.*
import kotlinx.android.synthetic.main.fragment_work.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Work.newInstance] factory method to
 * create an instance of this fragment.
 */

private var layoutManager: RecyclerView.LayoutManager? = null
private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

class Work : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view2.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter(getDataFromJson(view.context,"common"),3)
        }
        recycler_view3.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter(getDataFromJson(view.context,"common"),2)
        }
        recycler_view4.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter(getDataFromJson(view.context,"common"),1)
            //registerForContextMenu(recycler_view2)
        }

        fab.setOnClickListener{
            Toast.makeText(context,"thksjdadfsa",Toast.LENGTH_LONG).show()
            showCustomDialog(requireContext())
        }

    }

    private fun showCustomDialog(context: Context) {
        val dialogBinding: LayoutDialogueBinding? =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.layout_dialogue,
                null,
                false
            )

        val customDialog = AlertDialog.Builder(context, 0).create()

        customDialog.apply {
            setView(dialogBinding?.root)
            setCancelable(false)
        }.show()

        dialogBinding?.btnOk?.setOnClickListener {
            val currentData:ArrayList<CommonData> = getDataFromJson(context,"common") as ArrayList<CommonData>
            currentData.add(CommonData("111","Then new data","the new detail is here","the new footer",2))
            recycler_view2.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = RecyclerAdapter(currentData, 2)
                customDialog.dismiss()
            }
        }
    }


//    override fun onCreateContextMenu(
//        menu: ContextMenu,
//        v: View,
//        menuInfo: ContextMenu.ContextMenuInfo?
//    ) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        menu!!.setHeaderTitle("Select action")
//        //Toast.makeText(applicationContext, "$item menu selected", Toast.LENGTH_LONG).show()
//    }

}