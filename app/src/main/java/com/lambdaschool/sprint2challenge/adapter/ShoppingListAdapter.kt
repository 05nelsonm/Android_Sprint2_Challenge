package com.lambdaschool.sprint2challenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.sprint2challenge.R
import com.lambdaschool.sprint2challenge.model.ShoppingItem
import com.lambdaschool.sprint2challenge.util.ShopingItemArrayConstructor.shoppingItem
import kotlinx.android.synthetic.main.shopping_item_layout.view.*

class ShoppingListAdapter(val data: MutableList<ShoppingItem>) :
    RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.item_image
        val name: TextView = view.item_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item_layout, parent, false)
        return ViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(data[position].itemIconId)
        holder.name.text = data[position].itemName
    }
}