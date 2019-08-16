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
        }
    }
}
