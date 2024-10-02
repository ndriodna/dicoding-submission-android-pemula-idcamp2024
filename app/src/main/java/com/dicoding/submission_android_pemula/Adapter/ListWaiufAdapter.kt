package com.dicoding.submission_android_pemula.Adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.Target
import com.dicoding.submission_android_pemula.Model.Waifu
import com.dicoding.submission_android_pemula.R
import com.dicoding.submission_android_pemula.databinding.ItemRowWaifuBinding
import com.dicoding.submission_android_pemula.helper.GlideHelper
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
        Glide.with(holder.binding.root).load(waifu.thumbnail).timeout(60000).diskCacheStrategy(
            DiskCacheStrategy.AUTOMATIC
        ).override(Target.SIZE_ORIGINAL).fitCenter().placeholder(R.drawable.place_holder)
            .into(holder.binding.imgCard)
        holder.binding.cardTitle.text = waifu.name
        holder.binding.cardRarity.text = waifu.rarity
        holder.binding.cardAttribute.text = waifu.attribute
        holder.binding.root.setOnClickListener {
            onClickItem?.invoke(waifu)
        }
        val getAttr = jsonHelper.getAttribute(holder.itemView.context, R.raw.chardb)
        when (waifu.attribute) {
            "Fusion" -> {
                val url = getAttr.getString("Fusion")
                holder.binding.cardAttribute.iconTint =
                    ContextCompat.getColorStateList(holder.itemView.context, R.color.fusion)
                GlideHelper.btnIconAttribute(
                    holder.itemView.context,
                    holder.binding.cardAttribute,
                    url
                )
            }

            "Glacio" -> {
                val url = getAttr.getString("Glacio")
                holder.binding.cardAttribute.iconTint =
                    ContextCompat.getColorStateList(holder.itemView.context, R.color.glacio)
                GlideHelper.btnIconAttribute(
                    holder.itemView.context,
                    holder.binding.cardAttribute,
                    url
                )
            }

            "Spectro" -> {
                val url = getAttr.getString("Spectro")
                holder.binding.cardAttribute.iconTint =
                    ContextCompat.getColorStateList(holder.itemView.context, R.color.spectro)
                GlideHelper.btnIconAttribute(
                    holder.itemView.context,
                    holder.binding.cardAttribute,
                    url
                )
            }

            "Electro" -> {
                val url = getAttr.getString("Electro")
                holder.binding.cardAttribute.iconTint =
                    ContextCompat.getColorStateList(holder.itemView.context, R.color.electro)
                GlideHelper.btnIconAttribute(
                    holder.itemView.context,
                    holder.binding.cardAttribute,
                    url
                )
            }

            "Aero" -> {
                val url = getAttr.getString("Aero")
                holder.binding.cardAttribute.iconTint =
                    ContextCompat.getColorStateList(holder.itemView.context, R.color.aero)
                GlideHelper.btnIconAttribute(
                    holder.itemView.context,
                    holder.binding.cardAttribute,
                    url
                )
            }

            "Havoc" -> {
                val url = getAttr.getString("Havoc")
                holder.binding.cardAttribute.iconTint =
                    ContextCompat.getColorStateList(holder.itemView.context, R.color.havoc)
                GlideHelper.btnIconAttribute(
                    holder.itemView.context,
                    holder.binding.cardAttribute,
                    url
                )
            }
        }
    }


}