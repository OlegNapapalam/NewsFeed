package com.example.newsfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.R

const val TYPE_HEADER = 0
const val TYPE_ITEM = 1
const val TYPE_PROMOTION = 2

class RecyclerViewAdapter(private val values: List<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    open class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var textView: TextView? = null
        var btn: Button? = null
        var imgPromotion: ImageView? = null

        init {
            textView = itemView?.findViewById(R.id.recyclerViewItemName)
            imgPromotion = itemView?.findViewById(R.id.imageView)
            btn = itemView?.findViewById(R.id.recyclerViewItemButton)
        }
    }

    override fun getItemCount() = values.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == TYPE_HEADER) {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_heder, parent, false)
            ViewHolder(itemView)
        } else if (viewType == TYPE_PROMOTION) {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_promotion, parent, false)
            ViewHolder(itemView)
        } else if (viewType == TYPE_ITEM) {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
            ViewHolder(itemView)
        } else {
            ViewHolder(null)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_HEADER) {
            holder.textView?.text = values[position]
        } else if (getItemViewType(position) == TYPE_PROMOTION) {
            holder.imgPromotion?.setImageResource(setPromotionImg())
            holder.textView?.text = values[position]
            holder.btn?.setOnClickListener { v ->
                val toast = Toast.makeText(v.context, values[position], Toast.LENGTH_SHORT)
                toast.show()
            }
        } else if (getItemViewType(position) == TYPE_ITEM) {
            holder.textView?.text = values[position]
            holder.btn?.setOnClickListener { v ->
                val toast = Toast.makeText(v.context, values[position], Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER
        else if (position % 5 == 0) TYPE_PROMOTION
        else TYPE_ITEM
    }

    private fun setPromotionImg(): Int {
        var img: Int = 0
        when ((1..3).shuffled().first()) {
            1 -> img = R.drawable.promotion_one
            2 -> img = R.drawable.promotion_two
            3 -> img = R.drawable.promotion_three
        }
        return img
    }

}


