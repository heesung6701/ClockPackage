package com.quokkaman.android.app.common.data

data class Alarm(
    val name: String,
    val time: Time,
    val activate: Boolean,
    val plan: AlarmPlan?,
    val repeatSetting: AlarmRepeat,
    val soundSetting: AlarmSound,
    val vibrateSetting: AlarmVibrate
)
