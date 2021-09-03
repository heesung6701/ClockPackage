package com.quokkaman.android.app.common.data

import java.util.*

class AlarmDayPlan(private val daySet: EnumSet<DayOfWeek>, private val offOnHoliday : Boolean = false) : AlarmPlan {
    override fun valid(date: Date): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = date
        // TODO check is Holiday.
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        return daySet.contains(DayOfWeek.create(day))
    }

    fun contains(dayOfWeek: DayOfWeek): Boolean {
        return daySet.contains(dayOfWeek)
    }
}