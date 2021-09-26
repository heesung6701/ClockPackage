package com.quokkaman.android.app.common.data

import android.os.Parcel
import android.os.Parcelable

data class AlarmRepeat(override var active: Boolean, val interval: Int, val repeat: Int) :
    AlarmSetting(active), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun getTitle(): String = "다시 울림"

    override fun getSummaryOn(): String = "${interval}분 ${repeat}회"
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (active) 1 else 0)
        parcel.writeInt(interval)
        parcel.writeInt(repeat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlarmRepeat> {
        override fun createFromParcel(parcel: Parcel): AlarmRepeat {
            return AlarmRepeat(parcel)
        }

        override fun newArray(size: Int): Array<AlarmRepeat?> {
            return arrayOfNulls(size)
        }
    }
}