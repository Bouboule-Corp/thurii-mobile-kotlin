package com.bouboulecorp.thurii

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentRegistrationWay : Fragment(R.layout.registration_way) {
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
        val continue_btn = getActivity()?.findViewById<Button>(R.id.continueBtn)

        continue_btn?.visibility = View.GONE

        return lay
    }
}