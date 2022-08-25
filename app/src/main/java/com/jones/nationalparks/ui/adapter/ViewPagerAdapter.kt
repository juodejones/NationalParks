package com.jones.nationalparks.ui.adapter

import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.jones.nationalparks.R
import com.jones.nationalparks.data.model.Image
import com.squareup.picasso.Picasso

class ViewPagerAdapter(val imageList: List<Image?>): RecyclerView.Adapter<ViewPagerAdapter.ImageSlider>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSlider {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_row, parent, false)
        return ImageSlider(view)
    }

    override fun onBindViewHolder(holder: ImageSlider, position: Int) {
        Picasso.get()
            .load(imageList[position]?.url)
            .fit()
            .placeholder(android.R.drawable.stat_notify_error)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class ImageSlider(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.view_pager_imageview)
    }

}