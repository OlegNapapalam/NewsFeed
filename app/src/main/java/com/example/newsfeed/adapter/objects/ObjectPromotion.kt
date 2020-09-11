package com.example.newsfeed.adapter.objects

import com.example.newsfeed.R

class ObjectPromotion(private val textItem: String){
    fun getThisTextItem(): String {
        return textItem
    }

    fun setPromotionImg(): Int {
        var img: Int = 0
        when ((1..3).shuffled().first()) {
            1 -> img = R.drawable.promotion_one
            2 -> img = R.drawable.promotion_two
            3 -> img = R.drawable.promotion_three
        }
        return img
    }
}