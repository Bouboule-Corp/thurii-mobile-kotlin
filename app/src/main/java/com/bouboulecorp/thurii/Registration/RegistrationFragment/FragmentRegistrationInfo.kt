package com.bouboulecorp.thurii.Registration.RegistrationFragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Spinner
import android.widget.AdapterView
import android.widget.Toast
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.R
import java.text.SimpleDateFormat
import java.util.*

class FragmentRegistrationInfo : Fragment(R.layout.registration_info) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    val formatDate = SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val lay = super.onCreateView(inflater, container, savedInstanceState)
        initial_spinners(lay!!)
        val continue_btn = getActivity()?.findViewById<Button>(R.id.continueBtn)
        continue_btn?.visibility = View.VISIBLE
        return lay
    }

    fun initial_spinners(lay: View) {
        // birthday
        val birthday = lay.findViewById<RelativeLayout>(R.id.date_layout)
        val dayRes = lay.findViewById<TextView>(R.id.date_res)
        birthday_listener(birthday, dayRes)
        // weight
        val weightAdapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.weights,
            R.layout.spinner_item
        )
        val weight = lay.findViewById<Spinner>(R.id.weight_spinner)
        weight_listener(weightAdapter, weight)
        // height
        val heightAdapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.heights,
            R.layout.spinner_item
        )
        val height = lay.findViewById<Spinner>(R.id.height_spinner)
        height_listener(heightAdapter, height)
    }

    fun birthday_listener(birthday: RelativeLayout, dayRes: TextView) {
        birthday.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                requireActivity(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener {
                        datePicker, i, i2, i3 ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date = formatDate.format(selectDate.time)
                    Toast.makeText(context, "Data: " + date, Toast.LENGTH_SHORT).show()
                    dayRes.setText(date)
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }
    }

    fun weight_listener(weightAdapter: ArrayAdapter<CharSequence>, weight: Spinner) {
        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        weight.adapter = weightAdapter
        weight.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    val selectedItem = parent!!.getItemAtPosition(position)
                    Toast.makeText(
                        requireActivity(),
                        "$selectedItem Selected",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    fun height_listener(heightAdapter: ArrayAdapter<CharSequence>, height: Spinner) {
        val continue_btn = getActivity()?.findViewById<Button>(
            R.id.continueBtn
        )
        heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        height.adapter = heightAdapter
        height.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position != 0) {
                    val selectedItem = parent!!.getItemAtPosition(position)
                    Toast.makeText(
                        requireActivity(),
                        "$selectedItem Selected",
                        Toast.LENGTH_SHORT
                    ).show()
                    continue_btn?.setBackgroundColor(
                        ContextCompat.getColor(
                            requireActivity(), R.color.custom_color_primary_
                        )
                    )
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}
