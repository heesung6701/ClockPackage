package com.quokkaman.android.app.common.data

import java.util.*

class AlarmDayPlan(private val daySet: EnumSet<DayOfWeek>) : AlarmPlan {
    override fun valid(date: Date): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = date
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        return daySet.contains(DayOfWeek.create(day))
    }

    fun contains(dayOfWeek: DayOfWeek): Boolean {
        return daySet.contains(dayOfWeek)
    }
}