package com.programtest.tryj.domain.model.chart

import com.google.gson.annotations.SerializedName

data class ChartResponseItem(
    val `data`: List<Data>,
    val type: String
)