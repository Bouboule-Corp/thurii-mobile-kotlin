package com.bouboulecorp.thurii.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.bouboulecorp.thurii.R

class map_recyclerview_item_adapter(
    private val filterButtonList: List<map_recyclerview_item>, private val layoutId: Int, private val cont : Context
) : RecyclerView.Adapter<map_recyclerview_item_adapter.ViewHolder>()
{
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button : ImageButton = view.findViewById(R.id.imageButtonItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentButton = filterButtonList[position]
        holder.button.setImageDrawable(AppCompatResources.getDrawable(cont, currentButton.image))
    }

    override fun getItemCount(): Int {
        return filterButtonList.size
    }
}