package com.programtest.tryj.domain.repository

import com.programtest.tryj.domain.model.promo.PromosItem

interface PromoRepository {

    suspend fun getPromo():ArrayList<PromosItem>

}