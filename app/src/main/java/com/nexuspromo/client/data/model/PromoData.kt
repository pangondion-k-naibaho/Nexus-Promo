package com.nexuspromo.client.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoData(
    @SerializedName("id") val id: Int?= 0,
    @SerializedName("attributes") val attributes: PromoAttributes?= null
) : Parcelable