package com.nexuspromo.client.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PromoAttributes(
    @SerializedName("title") val title: String?= "",
    @SerializedName("count") val count: Int?= 0,
    @SerializedName("alt") val alt: Int?= 0,
    @SerializedName("desc") val description: String?= "",
    @SerializedName("desc_promo") val promoDescription: String?= "",
    @SerializedName("latitude") val latitude: String?= "",
    @SerializedName("longitude") val longitude: String?= "",
    @SerializedName("lokasi") val location: String?= "",
    @SerializedName("nama") val name: String?= "",
    @SerializedName("name_promo") val promoName: String?= "",
    @SerializedName("createdAt") val createdAt: String?= "",
    @SerializedName("updatedAt") val updatedAt: String?= "",
    @SerializedName("img") val image: PromoImage?= null
) : Parcelable