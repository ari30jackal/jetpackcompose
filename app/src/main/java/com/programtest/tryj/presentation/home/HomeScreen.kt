package com.programtest.tryj.presentation.home


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.programtest.tryj.domain.model.promo.PromosItem
import com.programtest.tryj.presentation.Dimens.MediumPadding1
import com.programtest.tryj.presentation.common.PromoList

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    promos:List<PromosItem>, navigateToDetails: (PromosItem) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize().background(Color.White)
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {

        PromoList(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            promos = promos,  onClick = navigateToDetails
        )
    }
}