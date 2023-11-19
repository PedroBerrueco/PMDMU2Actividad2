package com.pberrueco.pmdmu2actividad

import android.os.Parcel
import android.os.Parcelable


@Parcelize
data class New(
    val title: String?,
    val image: String?,
    val description: String?,
    val author: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(image)
        parcel.writeString(description)
        parcel.writeString(author)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<New> {
        override fun createFromParcel(parcel: Parcel): New {
            return New(parcel)
        }

        override fun newArray(size: Int): Array<New?> {
            return arrayOfNulls(size)
        }
    }
}
