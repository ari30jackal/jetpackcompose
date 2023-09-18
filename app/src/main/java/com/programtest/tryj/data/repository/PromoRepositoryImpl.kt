package com.programtest.tryj.data.repository


import com.programtest.tryj.data.remote.PromoApi
import com.programtest.tryj.domain.model.promo.PromosItem

import com.programtest.tryj.domain.repository.PromoRepository

class PromoRepositoryImpl(
    private val promoApi: PromoApi
) : PromoRepository {

   override suspend fun getPromo():ArrayList<PromosItem> = promoApi.getPromo()


}