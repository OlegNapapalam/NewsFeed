package com.example.newsfeed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.R
import com.example.newsfeed.adapter.objects.ObjectHeader
import com.example.newsfeed.adapter.holders.ViewHolderHeader
import com.example.newsfeed.adapter.holders.ViewHolderItem
import com.example.newsfeed.adapter.holders.ViewHolderPromotion
import com.example.newsfeed.adapter.objects.ObjectItem
import com.example.newsfeed.adapter.objects.ObjectPromotion

const val TYPE_HEADER = 0
const val TYPE_ITEM = 1
const val TYPE_PROMOTION = 2

class RecyclerViewAdapter(private val values: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount() = values.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layout = 0
        val viewHolder: RecyclerView.ViewHolder?
        when (viewType) {
            TYPE_ITEM -> {
                layout = R.layout.recyclerview_item
                val itemView = LayoutInflater.from(parent.context).inflate(layout, parent, false)
                viewHolder = ViewHolderItem(itemView)
            }
            TYPE_HEADER -> {
                layout = R.layout.recyclerview_heder
                val hederView = LayoutInflater.from(parent.context).inflate(layout, parent, false)
                viewHolder = ViewHolderHeader(hederView)

            }
            TYPE_PROMOTION -> {
                layout = R.layout.recyclerview_promotion
                val promotionView =
                    LayoutInflater.from(parent.context).inflate(layout, parent, false)
                viewHolder = ViewHolderPromotion(promotionView)
            }
            else -> viewHolder = null
        }
        return viewHolder!!
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_ITEM -> {
                val objectItem = ObjectItem(values[position].toString())
                (holder as ViewHolderItem).setThisItem(objectItem)
            }
            TYPE_HEADER -> {
                val objectHeader = ObjectHeader(values[position].toString())
                (holder as ViewHolderHeader).setHeaderText(objectHeader)
            }
            TYPE_PROMOTION -> {
                val objectPromotion = ObjectPromotion(values[position].toString())
                (holder as ViewHolderPromotion).setThisPromotion(objectPromotion)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER
        else if (position % 5 == 0) TYPE_PROMOTION
        else TYPE_ITEM
    }

}


