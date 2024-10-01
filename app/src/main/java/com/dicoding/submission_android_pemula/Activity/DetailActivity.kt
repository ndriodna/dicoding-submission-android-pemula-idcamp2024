package com.dicoding.submission_android_pemula.Activity

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.dicoding.submission_android_pemula.Model.Waifu
import com.dicoding.submission_android_pemula.R
import com.dicoding.submission_android_pemula.databinding.ActivityDetailBinding
import com.dicoding.submission_android_pemula.helper.jsonHelper

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Waifu Details"

        val waifu = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("waifu",Waifu::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("waifu")
        }

        binding.detailName.text = waifu?.name
        binding.detailAttribute.text = waifu?.attribute
        binding.detailRarity.text = waifu?.rarity
        binding.detailBirth.text = waifu?.birth
        binding.detailDesc.text = waifu?.desc

        Glide.with(this).load(waifu?.img).into(binding.detailImg)
         Glide.with(this).load(waifu?.thumbnail).into(binding.detailImgProfile)

         val attributeUrl = jsonHelper.getAttribute(this, R.raw.chardb)
        when(waifu?.attribute){
            "Fusion" -> {
                val url = attributeUrl.getString("Fusion")
                binding.detailImg.setBackgroundColor(ContextCompat.getColor(this,R.color.fusion))
                Glide.with(this).load(url).into(binding.detailImgAttribute)
            }
            "Glacio" -> {
                val url = attributeUrl.getString("Glacio")
                binding.detailImg.setBackgroundColor(ContextCompat.getColor(this,R.color.glacio))
                Glide.with(this).load(url).into(binding.detailImgAttribute)
            }
            "Electro" -> {
                val url = attributeUrl.getString("Electro")
                binding.detailImg.setBackgroundColor(ContextCompat.getColor(this,R.color.electro))
                Glide.with(this).load(url).into(binding.detailImgAttribute)
            }
            "Spectro" -> {
                val url = attributeUrl.getString("Spectro")
                binding.detailImg.setBackgroundColor(ContextCompat.getColor(this,R.color.spectro))
                Glide.with(this).load(url).into(binding.detailImgAttribute)
            }
            "Aero" -> {
                val url = attributeUrl.getString("Aero")
                binding.detailImg.setBackgroundColor(ContextCompat.getColor(this,R.color.aero))
                Glide.with(this).load(url).into(binding.detailImgAttribute)
            }
            "Havoc" -> {
                val url = attributeUrl.getString("Havoc")
                binding.detailImg.setBackgroundColor(ContextCompat.getColor(this,R.color.havoc))
                Glide.with(this).load(url).into(binding.detailImgAttribute)
            }
        }
    }
}