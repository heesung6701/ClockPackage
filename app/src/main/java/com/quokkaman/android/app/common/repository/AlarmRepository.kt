package com.quokkaman.android.app.common.repository

import com.quokkaman.android.app.common.data.Alarm

interface AlarmRepository {
    fun getDummyAlarmList(size: Int) : List<Alarm>

    fun create(alarm: Alarm)

    fun read(): List<Alarm>

    fun update(alarm: Alarm)

    fun delete(alarm: Alarm)
}