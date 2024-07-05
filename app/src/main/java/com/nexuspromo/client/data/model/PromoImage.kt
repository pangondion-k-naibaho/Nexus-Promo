package com.nexuspromo.client.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoImage(
    @SerializedName("data") val imageData: ImageData?= null
) : Parcelable