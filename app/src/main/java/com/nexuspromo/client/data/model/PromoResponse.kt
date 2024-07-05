package com.nexuspromo.client.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoResponse(
    @SerializedName("data") val data: List<PromoData>?= null,
    @SerializedName("meta") val meta: Meta?= null
) : Parcelable