package com.dicoding.submission_android_pemula.Adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.dicoding.submission_android_pemula.MainActivity
import com.dicoding.submission_android_pemula.Model.Waifu
import com.dicoding.submission_android_pemula.R
import com.dicoding.submission_android_pemula.databinding.ItemRowWaifuBinding
import com.dicoding.submission_android_pemula.helper.jsonHelper

class ListWaiufAdapter(private val listWaifu: ArrayList<Waifu>) :
    RecyclerView.Adapter<ListWaiufAdapter.ListviewHolder>() {

    var onClickItem: ((Waifu) -> Unit)? = null

    inner class ListviewHolder(val binding: ItemRowWaifuBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListviewHolder {
        val binding =
            ItemRowWaifuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListviewHolder(binding)
    }

    override fun getItemCount(): Int = listWaifu.size

    override fun onBindViewHolder(holder: ListviewHolder, position: Int) {
        val waifu = listWaifu[position]
        val attributeUrl = jsonHelper.getAttribute(holder.binding.root.context, R.raw.chardb)
        Glide.with(holder.binding.root).load(waifu.thumbnail).timeout(60000).diskCacheStrategy(
            DiskCacheStrategy.AUTOMATIC).placeholder(R.drawable.place_holder).into(holder.binding.imgCard)
        holder.binding.cardTitle.text = waifu.name
        holder.binding.cardRarity.text = waifu.rarity
        holder.binding.cardAttribute.text = waifu.attribute
        when (waifu?.attribute) {
            "Fusion" -> {
                val attribute = attributeUrl.getString("Fusion")
                holder.binding.cardAttribute.iconTint =
                    ColorStateList.valueOf(Color.parseColor("#FF0000"))
                imgAttribute(holder, attribute)
            }

            "Glacio" -> {
                val attribute = attributeUrl.getString("Glacio")
                holder.binding.cardAttribute.iconTint =
                    ColorStateList.valueOf(Color.parseColor("#51e0fc"))
                imgAttribute(holder, attribute)
            }

            "Spectro" -> {
                val attribute = attributeUrl.getString("Spectro")
                holder.binding.cardAttribute.iconTint =
                    ColorStateList.valueOf(Color.parseColor("#fcf651"))
                imgAttribute(holder, attribute)
            }

            "Electro" -> {
                val attribute = attributeUrl.getString("Electro")
                holder.binding.cardAttribute.iconTint =
                    ColorStateList.valueOf(Color.parseColor("#ac51fc"))
                imgAttribute(holder, attribute)
            }

            "Aero" -> {
                val attribute = attributeUrl.getString("Aero")
                holder.binding.cardAttribute.iconTint =
                    ColorStateList.valueOf(Color.parseColor("#51fcb5"))
                imgAttribute(holder, attribute)
            }

            "Havoc" -> {
                val attribute = attributeUrl.getString("Havoc")
                holder.binding.cardAttribute.iconTint =
                    ColorStateList.valueOf(Color.parseColor("#a62828"))
                imgAttribute(holder, attribute)
            }
        }
        holder.binding.root.setOnClickListener {
            onClickItem?.invoke(waifu)
        }
    }

    private fun imgAttribute(holder: ListviewHolder, attribute: String) {
        Glide.with(holder.binding.root).load(attribute).into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                holder.binding.cardAttribute.icon = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }
        })
    }

}