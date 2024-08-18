package com.isllam.bankingapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isllam.bankingapp.data.Card
import com.isllam.bankingapp.ui.theme.BlueEnd
import com.isllam.bankingapp.ui.theme.BlueStart
import com.isllam.bankingapp.ui.theme.OrangeEnd
import com.isllam.bankingapp.ui.theme.OrangeStart
import com.isllam.bankingapp.ui.theme.PurpleEnd
import com.isllam.bankingapp.ui.theme.PurpleStart

val cards = listOf(
    Card(
        "VISA",
        "3444 0000 9888 0999",
        "Business",
        33.99,
        getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        "MASTER CARDS",
        "3454 0110 9848 0699",
        "Savings",
        80.50,
        getGradient(BlueStart, BlueEnd)
    ),
    Card(
        "VISA",
        "3454 5500 9558 0669",
        "School",
        70.45,
        getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        "MASTER CARDS",
        "3234 0110 4488 7799",
        "Trips",
        66.99,
        getGradient(PurpleStart, PurpleEnd)
    ),
)

fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardsSection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index, cards[index])
        }
    }
}

@Composable
fun CardItem(index: Int, card: Card) {
    var lastItemPadding = 0.dp
    if (index == cards.size - 1) {
        lastItemPadding = 16.dp
    }
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") image = painterResource(id = R.drawable.ic_mastercard)
    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastItemPadding)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable { }
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = image, contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}
