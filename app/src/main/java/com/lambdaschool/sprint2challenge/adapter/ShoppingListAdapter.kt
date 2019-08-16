package com.lambdaschool.sprint2challenge.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Color.parseColor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.sprint2challenge.R
import com.lambdaschool.sprint2challenge.model.ShoppingItem
import com.lambdaschool.sprint2challenge.util.SelectedList.selectedItemList
import kotlinx.android.synthetic.main.shopping_item_layout.view.*

class ShoppingListAdapter(val data: MutableList<ShoppingItem>) :
    RecyclerView.Adapter<ShoppingListAdapter.ViewHolder>() {

    lateinit var context: Context
    val accentColor = "#D81B60"
    val whiteColor = "#FFFFFF"


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.item_image
        val name: TextView = view.item_name
        val itemCard = view.item_card
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
        if (data[position].itemSelected) {
            holder.itemCard.setCardBackgroundColor(parseColor(accentColor))
        } else {
            holder.itemCard.setCardBackgroundColor(parseColor(whiteColor))
        }


        holder.itemCard.setOnClickListener {
            // add to list and change color
            if (data[position].itemSelected) {
                data[position].itemSelected = false
                holder.itemCard.setCardBackgroundColor(parseColor(whiteColor))
                println("ITEM REMOVED FROM LIST: " + data[position].selectedItemIndex.toString())
                selectedItemList.removeAt(data[position].selectedItemIndex)

                // refactor selectedItemList's index values
                for (i in 0 until selectedItemList.size) {
                    selectedItemList[i].selectedItemIndex = i
                }
            } else {
                data[position].itemSelected = true
                holder.itemCard.setCardBackgroundColor(parseColor(accentColor))
                data[position].selectedItemIndex = selectedItemList.size
                selectedItemList.add(data[position])
                println("ITEM ADDED TO LIST: " + data[position].selectedItemIndex.toString())
            }
        }
    }
}