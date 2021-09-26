package com.quokkaman.android.app.common.data

import android.os.Parcel
import android.os.Parcelable

data class AlarmVibrate(override var active: Boolean, val type: Type) : AlarmSetting(active), Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readByte() != 0.toByte(),
        Type.valueOf(parcel.readString()?:"")
    )

    override fun getTitle(): String = "진동"

    override fun getSummaryOn(): String = type.name
    
    enum class Type(name: String) {
        None(""),
        BasicCall("Basic call"),
        Heartbeat("Heartbeat"),
        Ticktock("Ticktock"),
        Waltz("Waltz"),
        ZigZigZig("Zig-zig-zig"),
        Offbeat("Off-beat"),
        Spinning("Spinning"),
        Siren("Siren"),
        Telephone("Telephone"),
        Ripple("Ripple"),
        Bounce("Bounce"),
        Tap("TAp"),
        Dubstep("Dubstep"),
        Fireworks("Fireworks"),
        Gallop("Gallop"),
        Shuffle("shuffle"),
        Spring("Spring");
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (active) 1 else 0)
        parcel.writeString(type.name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AlarmVibrate> {
        override fun createFromParcel(parcel: Parcel): AlarmVibrate {
            return AlarmVibrate(parcel)
        }

        override fun newArray(size: Int): Array<AlarmVibrate?> {
            return arrayOfNulls(size)
        }
    }
}

