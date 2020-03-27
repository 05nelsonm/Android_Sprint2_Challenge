package com.lambdaschool.sprint2challenge.util

import com.lambdaschool.sprint2challenge.model.ShoppingItem
import com.lambdaschool.sprint2challenge.model.ShoppingItemConstants

object ShopingItemArrayConstructor {

    val shoppingItem: ArrayList<ShoppingItem>

        get() {

            val tempArrayList = ArrayList<ShoppingItem>()
            var i = 0

            ShoppingItemConstants.ICON_IDS.forEach {
                // ShoppingItem(itemResourceId: Int,  itemName: String, itemSelected: Boolean, itemIndex: Int)
                tempArrayList.add( ShoppingItem(it, ShoppingItemConstants.ITEM_NAMES_RAW[i], false, i) )
                i++
            }

            return tempArrayList

        }
}