package com.programtest.tryj.presentation.home

import com.programtest.tryj.domain.model.promo.PromosItem


data class HomeState(
    val promoList: ArrayList<PromosItem>
)