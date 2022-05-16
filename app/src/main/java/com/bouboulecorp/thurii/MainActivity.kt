package com.bouboulecorp.thurii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.bouboulecorp.thurii.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items1 = listOf("1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007")
        val adapter1 = ArrayAdapter(this, R.layout.register_info_list, items1)
        binding.weightField.setAdapter(adapter1)

        val items2 = listOf("50kg","51kg","52kg","53kg","54kg","55kg","55kg","56kg","57kg","58kg","59kg","60kg","61kg","62kg","63kg","64kg","65kg","66kg","67kg","68kg","69kg")
        val adapter2 = ArrayAdapter(this, R.layout.register_info_list, items2)
        binding.weightField.setAdapter(adapter2)

        val items3 = listOf("160cm","161cm","162cm","163cm","164cm","165cm","166cm","167cm","168cm","169cm","170cm","171cm","172cm","173cm","174cm","175cm","176cm","177cm","178cm","179cm","180cm")
        val adapter3 = ArrayAdapter(this, R.layout.register_info_list, items3)
        binding.heightField.setAdapter(adapter3)
    }
}