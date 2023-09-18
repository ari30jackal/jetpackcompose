package com.programtest.tryj.data.remote

import com.programtest.tryj.domain.model.promo.PromosItem
import retrofit2.http.GET

interface PromoApi {
    @GET("promos")
    suspend fun getPromo(
    ):ArrayList<PromosItem>
}