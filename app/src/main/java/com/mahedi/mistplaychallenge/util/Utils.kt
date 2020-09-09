package com.mahedi.mistplaychallenge.util

/**
 * @author Mahedi Hassan
 * 2020-09-08
 */
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahedi.mistplaychallenge.R

fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .centerCrop()
        .error(R.mipmap.ic_launcher)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}