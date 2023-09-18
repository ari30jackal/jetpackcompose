package com.programtest.tryj.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.programtest.tryj.R
import com.programtest.tryj.domain.model.promo.PromosItem
import com.programtest.tryj.presentation.Dimens.ExtraSmallPadding
import com.programtest.tryj.presentation.Dimens.ExtraSmallPadding2
import com.programtest.tryj.presentation.Dimens.PromoCardSize
import com.programtest.tryj.presentation.Dimens.SmallIconSize


@Composable
fun PromoCard(
    modifier: Modifier = Modifier,
    promosItem: PromosItem,
    onClick: (() -> Unit)? = null
) {
    val context = LocalContext.current
    Row(
        modifier = modifier.height(intrinsicSize = IntrinsicSize.Max).fillMaxWidth().background(Color(0.8f, 0.8f, 0.8f, 1f)).clickable { onClick?.invoke() },
        ) {

        AsyncImage(
            modifier = Modifier
                .size(PromoCardSize)
                .clip(MaterialTheme.shapes.medium).padding(1.dp),

            model = ImageRequest.Builder(context).data(promosItem.img.url).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(PromoCardSize)
        ) {
            Text(
                text = promosItem.nama,
                style = MaterialTheme.typography.bodyMedium.copy(),
                color = colorResource(id = R.color.black),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = promosItem.lokasi,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.baseline_back_hand_24),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding))
                Text(
                    text = promosItem.createdAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = R.color.body)
                )
            }
        }
    }
}
