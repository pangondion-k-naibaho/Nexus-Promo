package com.nexuspromo.client.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberAsyncImagePainter
import com.nexuspromo.client.R
import com.nexuspromo.client.data.model.Constants
import com.nexuspromo.client.data.model.Constants.VARIOUS_URL.Companion.IMAGE_URL
import com.nexuspromo.client.data.model.PromoData
import com.nexuspromo.client.ui.theme.blue2
import com.nexuspromo.client.utils.Extension.Companion.TextWithIcon
import com.nexuspromo.client.utils.Extension.Companion.convertDate

@Composable
fun DetailScreen(dataPromo: PromoData){
    val scrollState = rememberScrollState()
    ConstraintLayout (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ){
        val (image, title, location, date, description) = createRefs()

        val urlPromoImage = IMAGE_URL + dataPromo.attributes?.image?.imageData?.attributes?.url!!
        val promoTitle = dataPromo.attributes.title
        val promoLocation = dataPromo.attributes.location
        val promoDate = dataPromo.attributes.updatedAt
        val promoDescription = dataPromo.attributes.description

        Image(
            painter = rememberAsyncImagePainter(urlPromoImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .padding(top = 10.dp)
        )

        Text(
            text = promoTitle!!,
            color = blue2,
            fontSize = 25.sp,
            modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(image.bottom)
                }
                .padding(top = 10.dp)
        )

        TextWithIcon(
            input = promoLocation!!,
            iconResId = R.drawable.ic_location,
            modifier = Modifier
                .constrainAs(location) {
                    start.linkTo(parent.start)
                    top.linkTo(title.bottom)
                }
                .padding(top = 10.dp, start = 5.dp)
        )

        TextWithIcon(input = promoDate!!.convertDate(),
            iconResId = R.drawable.ic_calendar,
            modifier = Modifier
                .constrainAs(date) {
                    start.linkTo(parent.start)
                    top.linkTo(location.bottom)
                }
                .padding(top = 10.dp, start = 5.dp)
        )

        Text(
            text = promoDescription!!,
            modifier = Modifier
                .constrainAs(description){
                    start.linkTo(parent.start)
                    top.linkTo(date.bottom)
                    width = Dimension.fillToConstraints
                }
                .padding(top = 10.dp)
                .padding(horizontal = 5.dp)
        )
    }
}