package com.werockstar.withkoin.data.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserResponse(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    val bio: String?
) : Parcelable