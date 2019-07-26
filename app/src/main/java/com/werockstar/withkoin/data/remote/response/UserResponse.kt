package com.werockstar.withkoin.data.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserResponse(val id: Int, val login: String, val url: String, val bio: String?) : Parcelable