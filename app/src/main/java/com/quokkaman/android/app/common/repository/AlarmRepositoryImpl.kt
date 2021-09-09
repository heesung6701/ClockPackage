package com.quokkaman.android.app.common.repository

import com.quokkaman.android.app.common.data.*
import java.util.*

class AlarmRepositoryImpl : AlarmRepository {
    override fun getDummyAlarmList(size: Int): List<Alarm> {
        return IntRange(0, 20)
            .map { idx ->
                Alarm(name = "name$idx",
                    time = Time.create(idx.toShort().coerceIn(0, 23), (Math.random() * 100).toInt().toShort().coerceIn(0, 59)),
                    plan = AlarmDayPlan(EnumSet.of(DayOfWeek.values()[(Math.random() * 100).toInt() % 7])),
                    activate = false,
                    repeatSetting = AlarmRepeat(false, 5, 3),
                    soundSetting = AlarmSound(false, "" /* TODO sound default 값 적ㅇㅇ*/, 0.8f),
                    vibrateSetting = AlarmVibrate(false, AlarmVibrate.Type.BasicCall)
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