package com.lambdaschool.sprint2challenge.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lambdaschool.sprint2challenge.R
import com.lambdaschool.sprint2challenge.adapter.ShoppingListAdapter
import com.lambdaschool.sprint2challenge.model.ShoppingItem
import com.lambdaschool.sprint2challenge.util.SelectedList.selectedItemList
import com.lambdaschool.sprint2challenge.util.ShopingItemArrayConstructor.shoppingItem
import kotlinx.android.synthetic.main.activity_shopping_list.*

class ShoppingListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        list_view.setHasFixedSize(true)
        val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = ShoppingListAdapter(shoppingItem)
        list_view.layoutManager = manager
        list_view.adapter = adapter

        btn_send_list.setOnClickListener {
            val sendItems = mutableListOf<String>()

            // populate list into readable format
            for (i in 0 until selectedItemList.size) {
                sendItems.add(selectedItemList[i].itemName)
            }

            val sendItemsRefined = sendItems.joinToString(", ")

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Please pick me up to following: $sendItemsRefined")
            intent.type = "text/plain"
            startActivity(intent)
        }
    }
}
