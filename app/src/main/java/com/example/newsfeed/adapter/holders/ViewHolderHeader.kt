package com.example.newsfeed.adapter.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.adapter.objects.ObjectHeader
import kotlinx.android.synthetic.main.recyclerview_heder.view.*

class ViewHolderHeader(itemView: View) : RecyclerView.ViewHolder(itemView) {
     private val textView: TextView = itemView.recyclerViewItemName

    fun setHeaderText(header: ObjectHeader) {
        val headerText = header.getUserName()
        textView.text = headerText
    }

}
