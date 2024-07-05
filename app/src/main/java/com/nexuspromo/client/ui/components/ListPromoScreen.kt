package com.nexuspromo.client.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nexuspromo.client.R
import com.nexuspromo.client.data.model.Constants.VARIOUS_URL.Companion.IMAGE_URL
import com.nexuspromo.client.data.model.PromoAttributes
import com.nexuspromo.client.data.model.PromoData
import com.nexuspromo.client.data.model.PromoResponse
import com.nexuspromo.client.ui.theme.grey
import com.nexuspromo.client.ui.theme.white
import com.nexuspromo.client.utils.Extension
import com.nexuspromo.client.utils.Extension.Companion.TextWithIcon
import com.nexuspromo.client.utils.Extension.Companion.UrlImage
import org.w3c.dom.Text

@Composable
fun ListPromoScreen(promoResponse: PromoResponse, modifier: Modifier) {
    LazyColumn(modifier = modifier){
        items(promoResponse.data!!){dataPromo ->
            PromoItem(item = dataPromo)
        }
    }
}

@Composable
fun PromoItem(item: PromoData){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                color = white,
                shape = RoundedCornerShape(5.dp)
            )
            .border(
                width = 2.dp,
                color = grey,
                shape = RoundedCornerShape(5.dp)
            )
    ) {
        val (image, title, location, description) = createRefs()

        UrlImage(
            url = IMAGE_URL+item.attributes!!.image!!.imageData!!.attributes!!.url!!,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                },
            contentDescription = null
        )

        Text(
            text = item.attributes.title!!,
            modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(image.end)
                    top.linkTo(image.top)
                }
                .padding(start = 10.dp),
            fontSize = 16.sp
        )

        TextWithIcon(
            input = item.attributes.location!!,
            iconResId = R.drawable.ic_location,
            modifier = Modifier
                .constrainAs(location) {
                    start.linkTo(title.start)
                    top.linkTo(title.bottom)
                }
                .padding(top = 5.dp)
        )

        Text(
            text = item.attributes.description!!,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(description){
                    start.linkTo(location.start)
                    top.linkTo(location.bottom)
                    bottom.linkTo(parent.bottom)
                },
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}