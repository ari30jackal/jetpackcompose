package com.programtest.tryj.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.programtest.tryj.domain.model.promo.PromosItem
import com.programtest.tryj.presentation.Dimens.ExtraSmallPadding2
import com.programtest.tryj.presentation.Dimens.MediumPadding1
import com.programtest.tryj.presentation.home.components.PromoCard

@Composable
fun PromoList(
    modifier: Modifier = Modifier,
    promos:List<PromosItem>, onClick:(PromosItem) -> Unit
) {




        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {
            for (i in promos.indices){
                items(
                    count = promos.size,
                ) {
                    promos[it]?.let { promos ->
                        PromoCard(promosItem = promos, onClick = {onClick(promos)})
                    }
                }
            }

        }

}


//
//@Composable
//fun ShimmerEffect() {
//    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)){
//        repeat(10){
//            PromoShimmerEffect(
//                modifier = Modifier.padding(horizontal = MediumPadding1)
//            )
//        }
//    }
//}