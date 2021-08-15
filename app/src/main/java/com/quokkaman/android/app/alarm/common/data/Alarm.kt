package com.quokkaman.android.app.alarm.common.data

import java.util.*

data class Alarm(
    val name: String,
    val time: Time,
    val date: Date?,
    val day: Int?,
    val againSetting: AlarmSetting<AlarmAgain>,
    val soundSetting: AlarmSetting<AlarmSound>,
    val vibrateSetting: AlarmSetting<AlarmVibrate>
)
