package com.quokkaman.android.app.common.data

import java.util.*

class AlarmDayPlan(
    private val daySet: EnumSet<DayOfWeek>,
    private val offOnHoliday: Boolean = false
) : AlarmPlan {
    override fun valid(date: Date): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = date
        // TODO check is Holiday.
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        return daySet.contains(DayOfWeek.create(day))
    }

    override fun getTitle(): String {
        if (daySet.size == 7) {
            return "매일"
        }
        return "매주 " + daySet.joinToString(", ") { it.dayStr }
    }

    fun contains(dayOfWeek: DayOfWeek): Boolean {
        return daySet.contains(dayOfWeek)
    }

    fun toggle(dayOfWeek: DayOfWeek) {
        dayOfWeek.run {
            if (contains(this)) {
                daySet.remove(this)
            } else {
                daySet.add(this)
            }
        }
    }

    fun isEmpty() = daySet.isEmpty()
}