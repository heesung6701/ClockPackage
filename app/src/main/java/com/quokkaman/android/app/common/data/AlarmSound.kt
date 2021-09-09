package com.quokkaman.android.app.common.data

import android.os.Parcel
import android.os.Parcelable

data class AlarmSound(override var active: Boolean, val name: String, val volume: Float) : AlarmSetting(active), Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        parcel.readString()?:"",
        parcel.readFloat()
    ) {
    }

    override fun getTitle(): String = "알람음"

    override fun getSummaryOn(): String = name
    
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (active) 1 else 0)
        parcel.writeString(name)
        parcel.writeFloat(volume)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlarmSound> {
        override fun createFromParcel(parcel: Parcel): AlarmSound {
            return AlarmSound(parcel)
        }

        override fun newArray(size: Int): Array<AlarmSound?> {
            return arrayOfNulls(size)
        }
    }
}
