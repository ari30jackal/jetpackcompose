package com.programtest.tryj.domain.usecases.promo

import com.programtest.tryj.domain.model.promo.PromosItem
import com.programtest.tryj.domain.repository.PromoRepository

class GetPromo(
    private val promoRepository: PromoRepository
) {
    suspend operator fun invoke():ArrayList<PromosItem>{
        return promoRepository.getPromo()
    }
}

