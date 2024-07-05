package com.nexuspromo.client.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
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
fun ListPromoScreen(promoResponse: PromoResponse, modifier: Modifier, onClick: (PromoData) -> Unit) {
    LazyColumn(modifier = modifier){
        items(promoResponse.data!!){dataPromo ->
            PromoItem(item = dataPromo, onClick = { onClick(dataPromo) })
        }
    }
}

@Composable
fun PromoItem(item: PromoData, onClick: (PromoData) -> Unit){
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
            .clickable { onClick(item) }
    ) {
        val (image, title, location, description) = createRefs()

        Image(
            painter = rememberAsyncImagePainter(IMAGE_URL+item.attributes?.image?.imageData?.attributes?.url!!),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
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
                    bottom.linkTo(location.top)
                }
                .padding(start = 5.dp),
            fontSize = 16.sp,
            color = Color.Black
        )

        TextWithIcon(
            input = item.attributes.location!!,
            iconResId = R.drawable.ic_location,
            modifier = Modifier
                .constrainAs(location) {
                    start.linkTo(title.start)
                    top.linkTo(title.bottom)
                    bottom.linkTo(description.top)
                }
                .padding(top = 5.dp, start = 5.dp)
        )

        Text(
            text = item.attributes.description!!,
            modifier = Modifier
                .constrainAs(description) {
                    start.linkTo(location.start)
                    top.linkTo(location.bottom)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                }
                .padding(top = 5.dp, start = 5.dp),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}