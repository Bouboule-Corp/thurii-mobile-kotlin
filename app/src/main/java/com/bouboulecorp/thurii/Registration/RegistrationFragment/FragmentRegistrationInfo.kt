package com.bouboulecorp.thurii.Registration.RegistrationFragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.bouboulecorp.thurii.R
import java.text.SimpleDateFormat
import java.util.*

class FragmentRegistrationInfo : Fragment(R.layout.registration_info) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
        }
    }

    val formatDate = SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val lay = super.onCreateView(inflater, container, savedInstanceState)

//        birthday picker
        val birthday = lay!!.findViewById<RelativeLayout>(R.id.date_layout)
        val day_res = lay!!.findViewById<TextView>(R.id.date_res)
        birthday.setOnClickListener{
            val getDate = Calendar.getInstance()
            val datepicker = DatePickerDialog(
                requireActivity(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener{
                    datePicker, i, i2, i3 ->
                        val selectDate = Calendar.getInstance()
                        selectDate.set(Calendar.YEAR, i)
                        selectDate.set(Calendar.MONTH, i2)
                        selectDate.set(Calendar.DAY_OF_MONTH, i3)
                        val date = formatDate.format(selectDate.time)
                        Toast.makeText(context, "Data: " + date, Toast.LENGTH_SHORT).show()
                        day_res.setText(date)
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datepicker.show()
        }
//        birthday picker
        val weight_adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.weights,
            R.layout.spinner_item
        )
        val weight = lay!!.findViewById<Spinner>(R.id.weight_spinner)
        weight_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        weight.adapter = weight_adapter
        weight.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val selectedItem = parent!!.getItemAtPosition(position)
                Toast.makeText(
                    requireActivity(),
                    "$selectedItem Selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        val height_adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.heights,
            R.layout.spinner_item
        )
        val height = lay!!.findViewById<Spinner>(R.id.height_spinner)
        height_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        height.adapter = height_adapter
        height.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val selectedItem = parent!!.getItemAtPosition(position)
                Toast.makeText(
                    requireActivity(),
                    "$selectedItem Selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        return lay
    }
}
