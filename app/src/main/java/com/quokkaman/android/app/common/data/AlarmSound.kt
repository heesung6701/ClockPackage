package com.quokkaman.android.app.common.data

data class AlarmSound(override var active: Boolean, val name: String, val volume: Float) : AlarmSetting(active) {
    override fun getTitle(): String = "알람음"

    override fun getSummaryOn(): String = name
}
