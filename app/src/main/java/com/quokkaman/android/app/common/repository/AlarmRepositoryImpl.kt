package com.quokkaman.android.app.common.repository

import com.quokkaman.android.app.common.data.*
import java.util.*

class AlarmRepositoryImpl : AlarmRepository {
    override fun getDummyAlarmList(size: Int): List<Alarm> {
        return IntRange(0, 20)
            .map { idx ->
                Alarm(name = "name$idx",
                    time = Time.create(idx.toShort().coerceIn(0, 23), (Math.random() * 100).toInt().toShort().coerceIn(0, 59)),
                    date = null,
                    plan = AlarmDayPlan(EnumSet.of(DayOfWeek.values()[(Math.random() * 100).toInt() % 7])),
                    activate = false,
                    repeatSetting = AlarmSetting(false, null),
                    soundSetting = AlarmSetting(false, null),
                    vibrateSetting = AlarmSetting(false, null)
                )
            }
    }

    override fun create(alarm: Alarm) {
        TODO("Not yet implemented")
    }

    override fun read(): List<Alarm> {
        TODO("Not yet implemented")
    }

    override fun update(alarm: Alarm) {
        TODO("Not yet implemented")
    }

    override fun delete(alarm: Alarm) {
        TODO("Not yet implemented")
    }
}