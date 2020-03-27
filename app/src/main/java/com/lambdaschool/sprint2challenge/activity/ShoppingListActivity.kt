package com.lambdaschool.sprint2challenge.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.sprint2challenge.R
import com.lambdaschool.sprint2challenge.adapter.ShoppingListAdapter
import com.lambdaschool.sprint2challenge.util.NotificationGenerator
import com.lambdaschool.sprint2challenge.util.SelectedList.selectedItemList
import com.lambdaschool.sprint2challenge.util.ShopingItemArrayConstructor.shoppingItem
import kotlinx.android.synthetic.main.activity_shopping_list.*

class ShoppingListActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID = 3871
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        list_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = ShoppingListAdapter(shoppingItem)
        list_view.layoutManager = manager
        list_view.adapter = adapter

        btn_send_list.setOnClickListener {

            // Show a toast if nothing's selected
            if (selectedItemList.size > 0) {

                NotificationGenerator.simpleNotification(this)

                // Initialize empty mutableList
                val sendItems = mutableListOf<String>()

                // populate mutableList with selectedItems
                for (i in 0 until selectedItemList.size) {
                    sendItems.add(selectedItemList[i].itemName.replace("_", " ", false))
                }

                // Sort the list alphabetically
                sendItems.sort()

                // Refine mutableList into a single string
                val sendItemsRefined = sendItems.joinToString(", ")

                // Share string of data with an app that can handle text/plain
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, "Please pick me up the following: $sendItemsRefined")
                intent.type = "text/plain"
                startActivity(intent)

            } else {
                Toast.makeText(this, "No items are selected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
