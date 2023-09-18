package com.programtest.tryj.domain.model.chart

import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("nominal")
    val nominal: Int,
    @SerializedName("trx_date")
    val trx_date: String
)