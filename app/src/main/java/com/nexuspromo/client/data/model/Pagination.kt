package com.nexuspromo.client.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pagination(
    @SerializedName("page") val page: Int?= 0,
    @SerializedName("pageSize") val pageSize: Int?= 0,
    @SerializedName("pageCount") val pageCount: Int?= 0,
    @SerializedName("total") val total: Int?= 0
) : Parcelable