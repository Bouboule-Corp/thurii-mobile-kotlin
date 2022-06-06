package com.bouboulecorp.thurii

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
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
            val datepicker = DatePickerDialog(requireActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener{
                datePicker, i, i2, i3 ->
                val selectDate = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, i)
                selectDate.set(Calendar.MONTH, i2)
                selectDate.set(Calendar.DAY_OF_MONTH, i3)
                val date = formatDate.format(selectDate.time)
                Toast.makeText(context, "Data: " + date, Toast.LENGTH_SHORT).show()
                day_res.setText(date)
            },getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datepicker.show()
        }

//        weight picker
        val weight = lay!!.findViewById<Spinner>(R.id.weight_layout)
//        val weight_res = lay!!.findViewById<TextView>(R.id.weight_res)

        val weights = arrayOf("40 kg", "41 kg", "42 kg", "43 kg", "44 kg", "45 kg", "46 kg", "47 kg", "48 kg", "49 kg", "50 kg", "51 kg", "52 kg", "53 kg", "54 kg", "55 kg", "56 kg", "57 kg", "58 kg", "59 kg", "60 kg", "61 kg", "62 kg", "63 kg", "64 kg", "65 kg", "66 kg", "67 kg", "68 kg", "69 kg", "70 kg", "71 kg", "72 kg", "73 kg", "74 kg", "75 kg", "76 kg", "77 kg", "78 kg", "79 kg", "80 kg", "81 kg", "82 kg", "83 kg", "84 kg", "85 kg", "86 kg", "87 kg", "88 kg", "89 kg", "90 kg", "91 kg", "92 kg", "93 kg", "94 kg", "95 kg", "96 kg", "97 kg", "98 kg", "99 kg", "100 kg", "101 kg", "102 kg", "103 kg", "104 kg", "105 kg", "106 kg", "107 kg", "108 kg", "109 kg", "110 kg", "111 kg", "112 kg", "113 kg", "114 kg", "115 kg", "116 kg", "117 kg", "118 kg", "119 kg", "120 kg", "121 kg", "122 kg", "123 kg", "124 kg", "125 kg", "126 kg", "127 kg", "128 kg", "129 kg", "130 kg", "131 kg", "132 kg", "133 kg", "134 kg", "135 kg", "136 kg", "137 kg", "138 kg", "139 kg", "140 kg", "141 kg", "142 kg", "143 kg", "144 kg", "145 kg", "146 kg", "147 kg", "148 kg", "149 kg", "150 kg", "151 kg", "152 kg", "153 kg", "154 kg", "155 kg", "156 kg", "157 kg", "158 kg", "159 kg", "160 kg", "161 kg", "162 kg", "163 kg", "164 kg", "165 kg", "166 kg", "167 kg", "168 kg", "169 kg", "170 kg", "171 kg", "172 kg", "173 kg", "174 kg", "175 kg", "176 kg", "177 kg", "178 kg", "179 kg")
        weight.adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, weights)

        weight.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                weight_res.text = "Select"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                weight_res.text = weights.get(p2)
            }
        }

//        height picker
        val height = lay!!.findViewById<Spinner>(R.id.height_layout)
//        val height_res = lay!!.findViewById<TextView>(R.id.height_res)

        val heights = arrayOf("150 cm", "151 cm", "152 cm", "153 cm", "154 cm", "155 cm", "156 cm", "157 cm", "158 cm", "159 cm", "160 cm", "161 cm", "162 cm", "163 cm", "164 cm", "165 cm", "166 cm", "167 cm", "168 cm", "169 cm", "170 cm", "171 cm", "172 cm", "173 cm", "174 cm", "175 cm", "176 cm", "177 cm", "178 cm", "179 cm", "180 cm", "181 cm", "182 cm", "183 cm", "184 cm", "185 cm", "186 cm", "187 cm", "188 cm", "189 cm", "190 cm", "191 cm", "192 cm", "193 cm", "194 cm", "195 cm", "196 cm", "197 cm", "198 cm", "199 cm")
        height.adapter = ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, heights)

        weight.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
//                height_res.text = "Select"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                height_res.text = heights.get(p2)
            }
        }
        return lay
    }
}