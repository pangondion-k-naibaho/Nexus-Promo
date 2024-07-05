package com.nexuspromo.client.ui.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.nexuspromo.client.R
import com.nexuspromo.client.ui.activities.detail.DetailActivity
import com.nexuspromo.client.ui.theme.blue2
import com.nexuspromo.client.ui.theme.blue3
import com.nexuspromo.client.ui.viewmodels.MainViewModel

@Composable
fun MainScreen(context: Context, viewModel: MainViewModel, onFail: () -> Unit){
    val promoResponse by viewModel.promoResponse.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val isFail by viewModel.isFail.collectAsState()

    if(isLoading){
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.6f))
        ){
            val circleProgress = createRef()
            CircularProgressIndicator(
                color = blue3,
                modifier = Modifier
                    .constrainAs(circleProgress){
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }else{
        if(isFail){
            onFail()
        }else{
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ){
                val (promoTitle, listPromo) = createRefs()

                Text(
                    text = context.getString(R.string.tvListPromoTitle),
                    color = blue2,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .constrainAs(promoTitle){
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        }
                )

                ListPromoScreen(promoResponse = promoResponse,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(listPromo) {
                            start.linkTo(parent.start)
                            top.linkTo(promoTitle.bottom)
                        }
                        .padding(top = 10.dp)
                        .padding(horizontal = 5.dp)
                ){
                    context.startActivity(
                        DetailActivity.newIntent(context, it)
                    )
                }
            }
        }
    }

}