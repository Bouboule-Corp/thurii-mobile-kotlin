package com.bouboulecorp.thurii

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class FragmentRegistrationGender : Fragment(R.layout.registration_gender) {
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

        val btn_female = lay!!.findViewById<ImageButton>(R.id.btn_female)
        val btn_male = lay!!.findViewById<ImageButton>(R.id.btn_male)

        btn_female.setOnClickListener {
            btn_female.setAlpha(1.0f)
            btn_male.setAlpha(0.4f)
        }
        btn_male.setOnClickListener {
            btn_male.setAlpha(1.0f)
            btn_female.setAlpha(0.4f)
        }
        return lay
    }
}