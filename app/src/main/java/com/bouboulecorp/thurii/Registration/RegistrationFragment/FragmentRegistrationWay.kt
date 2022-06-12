package com.bouboulecorp.thurii.Registration.RegistrationFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.EmailRegistration.RegisterEmailActivity
import com.bouboulecorp.thurii.LogIn.LoginActivity
import com.bouboulecorp.thurii.R

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

        val regi_mail = lay!!.findViewById<Button>(R.id.regi_mail)

        regi_mail.setOnClickListener() {
            val intent = Intent(requireActivity(), RegisterEmailActivity::class.java)
            requireActivity().startActivity(intent)
        }

        return lay
    }
}