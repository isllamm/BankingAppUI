package com.isllam.bankingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isllam.bankingapp.data.Finance
import com.isllam.bankingapp.ui.theme.BlueStart
import com.isllam.bankingapp.ui.theme.GreenStart
import com.isllam.bankingapp.ui.theme.OrangeStart
import com.isllam.bankingapp.ui.theme.PurpleStart

val finance = listOf(
    Finance(
        Icons.Rounded.StarHalf,
        "My\nBusiness",
        OrangeStart,
    ),
    Finance(
        Icons.Rounded.Wallet,
        "My\nWallet",
        BlueStart,
    ),
    Finance(
        Icons.Rounded.StarHalf,
        "Finance\nAnalytics",
        PurpleStart,
    ),
    Finance(
        Icons.Rounded.MonetizationOn,
        "My\nTransactions",
        GreenStart,
    )

)

@Composable
fun FinanceSection() {
    Column {
        Text(
            text = "Finance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )
        LazyRow {
            items(finance.size) { index ->
                FinanceItem(index)
            }
        }
    }
}

@Composable
fun FinanceItem(index: Int) {
    val financeItem = finance[index]
    var lastItemPadding = 0.dp
    if (index == finance.size - 1) lastItemPadding = 16.dp
    Box(modifier = Modifier.padding(start = 16.dp, end = lastItemPadding)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable { }
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(financeItem.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = financeItem.icon,
                    contentDescription = financeItem.name,
                    tint = Color.White
                )
            }
            Text(text = financeItem.name, color = MaterialTheme.colorScheme.onBackground)
        }
    }

}
