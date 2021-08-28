package com.quokkaman.android.app.common.data

import java.util.*

enum class DayOfWeek private constructor(val day: Int) {
    MONDAY(Calendar.MONDAY),
    TUESDAY(Calendar.TUESDAY),
    WEDNESDAY(Calendar.WEDNESDAY),
    THURSDAY(Calendar.THURSDAY),
    FRIDAY(Calendar.FRIDAY),
    SATURDAY(Calendar.SATURDAY),
    SUNDAY(Calendar.SUNDAY);

    companion object {
        fun create(day: Int): DayOfWeek {
            return values().first {
                it.day == day
            }
        }
    }
}