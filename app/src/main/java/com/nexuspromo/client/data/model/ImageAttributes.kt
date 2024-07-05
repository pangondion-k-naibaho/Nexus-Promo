package com.nexuspromo.client.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageAttributes(
    @SerializedName("name") val name: String?= "",
    @SerializedName("alternativeText") val alternativeText: String?= "",
    @SerializedName("caption") val caption: String?= "",
    @SerializedName("width") val width: Int?= 0,
    @SerializedName("height") val height: Int?= 0,
    @SerializedName("formats") val formats: Formats?= null,
    @SerializedName("hash") val hash: String?= "",
    @SerializedName("ext") val ext: String?= "",
    @SerializedName("mime") val mime: String?= "",
    @SerializedName("size") val size: Double?= 0.0,
    @SerializedName("url") val url: String?= "",
    @SerializedName("previewUrl") val previewUrl: String?= "",
    @SerializedName("provider") val provider: String?= "",
    @SerializedName("provider_metadata") val providerMetadata: String?= "",
    @SerializedName("createdAt") val createdAt: String?= "",
    @SerializedName("updatedAt") val updatedAt: String?= ""
) : Parcelable