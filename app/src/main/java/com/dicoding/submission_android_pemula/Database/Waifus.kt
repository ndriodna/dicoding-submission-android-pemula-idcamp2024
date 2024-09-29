package com.dicoding.submission_android_pemula.Database

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Waifus(
    val name: String,
    val img: String,
    val Desc: String,
    val rarity: String,
    val Attribute: String,
    val Birth: String
): Parcelable
