package com.quokkaman.android.app.common.data

import java.util.*

data class Alarm(
    val name: String,
    val time: Time,
    val date: Date?,
    val activate: Boolean,
    val plan: AlarmPlan?,
    val repeatSetting: AlarmSetting<AlarmRepeat>,
    val soundSetting: AlarmSetting<AlarmSound>,
    val vibrateSetting: AlarmSetting<AlarmVibrate>
)
