package com.dicoding.submission_android_pemula.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Waifu(
    val name: String?,
    val img: String?,
    val thumbnail: String?,
    val desc: String?,
    val rarity: String?,
    val attribute: String?,
    val birth: String?
): Parcelable
