package com.example.newsfeed.adapter.holders

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.adapter.objects.ObjectPromotion
import kotlinx.android.synthetic.main.recyclerview_promotion.view.*

open class ViewHolderPromotion(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView: TextView = itemView.recyclerViewItemName
    private val btn: Button = itemView.recyclerViewItemButton
    private val imgPromotion: ImageView = itemView.recyclerViewImagePromotion

    fun setThisPromotion(item: ObjectPromotion) {
        textView.text = item.getThisTextItem()
        imgPromotion.setImageResource(item.setPromotionImg())
        btn.setOnClickListener { v ->
            val toast = Toast.makeText(v.context, item.getThisTextItem(), Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}