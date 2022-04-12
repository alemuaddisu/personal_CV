package com.miu.aalemu.personal_cv.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miu.aalemu.personal_cv.R
import kotlinx.android.synthetic.main.fragment_contact.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Contact.newInstance] factory method to
 * create an instance of this fragment.
 */
class Contact : Fragment() {
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
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        email.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("addisudalemu@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Your Username and Password")
            if (context?.let { it1 -> intent.resolveActivity(it1.packageManager) } != null) {
                startActivity(intent)
            }
        }
        explore.setOnClickListener{
            val gmmIntentUri = Uri.parse("geo:39.8955452,-82.8883961")
            val mapIntent = Intent(Intent.ACTION_VIEW,gmmIntentUri)
            val dialIntent = Intent(Intent.ACTION_DIAL)
            startActivity(mapIntent)

        }
        call.setOnClickListener{
           val dialIntent = Intent(Intent.ACTION_DIAL)

            dialIntent.data = Uri.parse("tel:" + "5713312578")

              startActivity(dialIntent)

        }


    }

}