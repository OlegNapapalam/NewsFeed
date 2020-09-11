package com.example.newsfeed.adapter.holders

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.adapter.objects.ObjectItem
import kotlinx.android.synthetic.main.recyclerview_item.view.*

open class ViewHolderItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView: TextView = itemView.recyclerViewItemName
    private val btn: Button = itemView.recyclerViewItemButton

    fun setThisItem(item: ObjectItem) {
        textView.text = item.getThisTextItem()
        btn.setOnClickListener { v ->
            val toast = Toast.makeText(v.context, item.getThisTextItem(), Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}