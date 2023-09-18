package com.programtest.tryj.domain.model.promo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PromosItem(

    val Title: String?,
    val alt: String,
    val count: Int,
    val createdAt: String,
    val created_at: String,
    val desc: String,
    val desc_promo: String?,
    val id: Int,
    val latitude: String,
    val lokasi: String,
    val longitude: String,
    val nama: String,
    val img: Img,
    val name_promo: String?,
    val published_at: String,
    val updated_at: String
):Parcelable
