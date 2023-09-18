package com.programtest.tryj.domain.usecases.promo

import com.programtest.tryj.domain.repository.PromoRepository


data class PromoUseCases(val promoRepository: PromoRepository) {
    suspend operator fun invoke() = promoRepository.getPromo()
}