package com.bouboulecorp.thurii

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
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

        val sport_list = mutableListOf<String>()
        val txtV_list = listOf<TextView>(lay!!.findViewById<TextView>(R.id.first_choice_txt),
                                        lay!!.findViewById<TextView>(R.id.second_choice_txt),
                                        lay!!.findViewById<TextView>(R.id.third_choice_txt))

        btn_rando.setOnClickListener {
            btn_rando.setAlpha(1.0f)
            val s = sport_list.size;
            if (s != 3) sport_list.add("Rando");
            for (i in 0..s) {
                System.out.println("1" + sport_list);
                txtV_list[i].setText(sport_list[i])
            }
        }
        btn_escalade.setOnClickListener {
            btn_escalade.setAlpha(1.0f)
            val s = sport_list.size;
            if (s != 3) sport_list.add("Escalade");
            for (i in 0..s) {
                System.out.println("2" + sport_list);
                txtV_list[i].setText(sport_list[i])
            }
        }

        btn_snow.setOnClickListener {
            btn_snow.setAlpha(1.0f)
            val s = sport_list.size;
            if (s != 3) sport_list.add("Snow");
            for (i in 0..s) {
                System.out.println("3" + sport_list);
                txtV_list[i].setText(sport_list[i])
            }
        }
        return lay
    }
}
