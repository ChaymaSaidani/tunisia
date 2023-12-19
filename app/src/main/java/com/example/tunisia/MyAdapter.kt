package com.example.tunisia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

internal class MyAdapter(private val data: List<tunisia>, val listener: MainActivity) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val countryImage: ImageView = itemView.findViewById(R.id.countryImage)
        val countryName: TextView = itemView.findViewById(R.id.countryName)
        val btnDelete: FloatingActionButton = itemView.findViewById(R.id.fabDelete)


        fun bind(item: tunisia?, listener: MainActivity) {
            item?.let {
                countryImage.setImageResource(it.photoResourceId)
                countryName.text = it.name
            }

            itemView.setOnClickListener { v ->
                listener.onitemClicked(v, item)
            }

            btnDelete.setOnClickListener {
                if (item != null) {
                    listener.onItemDeleteClick(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, listener)
    }
}
