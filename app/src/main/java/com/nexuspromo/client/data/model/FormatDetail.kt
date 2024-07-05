package com.nexuspromo.client.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FormatDetail(
    @SerializedName("ext") val ext: String?= "",
    @SerializedName("url") val url: String?= "",
    @SerializedName("hash") val hash: String?= "",
    @SerializedName("mime") val mime: String?= "",
    @SerializedName("name") val name: String?= "",
    @SerializedName("path") val path: String?= "",
    @SerializedName("size") val size: Double?= 0.0,
    @SerializedName("width") val width: Int?= 0,
    @SerializedName("height") val height: Int?= 0
) : Parcelable