package com.programtest.tryj.domain.model.promo

data class Formats(
    val large: List<Large>,
    val medium: List<Medium>,
    val small: List<Small>,
    val thumbnail: List<Thumbnail>
)