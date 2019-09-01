package com.unava.dia.mmrchecker.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideUtil {
    companion object{
        fun setPlayerIcon(imageView: ImageView, avatarUrl: String) {
            val imageUrl = StringBuilder()
                .append(avatarUrl)
                .toString()

            val context = imageView.context

            Glide.with(context).load(imageUrl)
                .into(imageView)
        }
    }
}