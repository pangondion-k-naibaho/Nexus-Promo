package com.nexuspromo.client.ui.activities.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nexuspromo.client.data.model.PromoData
import com.nexuspromo.client.ui.components.DetailScreen
import com.nexuspromo.client.ui.theme.NexusPromoTheme

class DetailActivity : ComponentActivity() {
    private val TAG = DetailActivity::class.java.simpleName
    private lateinit var deliveredPromoData: PromoData

    companion object{
        const val DELIVERED_PROMO = "DELIVERED_PROMO"
        fun newIntent(context: Context, dataPromo: PromoData): Intent = Intent(context, DetailActivity::class.java)
            .putExtra(DELIVERED_PROMO, dataPromo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        deliveredPromoData = intent.extras!!.get(DELIVERED_PROMO) as PromoData
        Log.d(TAG, "delivered PromoData: $deliveredPromoData")

        setContent{
            NexusPromoTheme {
                DetailScreen(dataPromo = deliveredPromoData)
            }
        }
    }
}