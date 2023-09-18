package com.programtest.tryj.presentation.banking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import com.programtest.tryj.R
import com.programtest.tryj.presentation.Dimens

@Composable
fun BankingScreen(){
    Row(
        modifier = Modifier.height(intrinsicSize = IntrinsicSize.Max).width(intrinsicSize = IntrinsicSize.Max).fillMaxHeight().fillMaxWidth().background(
            Color(0.8f, 0.8f, 0.8f, 1f)
        ),
    ) {
    Text(
        text = "userName",
        style = MaterialTheme.typography.bodyMedium.copy(),
        color = colorResource(id = R.color.black),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
    Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))
    Text(
        text = "userSaldo",
        style = MaterialTheme.typography.bodyMedium.copy(),
        color = colorResource(id = R.color.black),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
    }
}