package com.nexuspromo.client.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Formats(
    @SerializedName("thumbnail") val thumbnail: FormatDetail?= null,
    @SerializedName("large") val large: FormatDetail?= null,
    @SerializedName("small") val small: FormatDetail?= null,
    @SerializedName("medium") val medium: FormatDetail?= null
) : Parcelable