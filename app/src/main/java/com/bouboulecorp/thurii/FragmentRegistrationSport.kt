package com.bouboulecorp.thurii

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import org.w3c.dom.Text

class FragmentRegistrationSport : Fragment(R.layout.registration_sport) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val lay = super.onCreateView(inflater, container, savedInstanceState)

        val btn_rando= lay!!.findViewById<ImageButton>(R.id.btn_rando)
        val btn_escalade = lay!!.findViewById<ImageButton>(R.id.btn_escalade)
        val btn_snow = lay!!.findViewById<ImageButton>(R.id.btn_snow)
//        val list = mutableListOf("")

        btn_rando.setOnClickListener {
            btn_rando.setAlpha(1.0f)
//            if (list.size != 3)
//                list.add("Rando")
        }
        btn_escalade.setOnClickListener {
            btn_escalade.setAlpha(1.0f)
//            if (list.size != 3)
//                list.add("Escalade")
        }

        btn_snow.setOnClickListener {
            btn_snow.setAlpha(1.0f)
//            if (list.size != 3)
//                list.add("Snow")
        }
        return lay
    }
}