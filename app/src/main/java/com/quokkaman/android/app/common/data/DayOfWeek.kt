package com.quokkaman.android.app.common.data

import java.util.*

enum class DayOfWeek private constructor(val day: Int, val dayStr: String) {
    MONDAY(Calendar.MONDAY, "월"),
    TUESDAY(Calendar.TUESDAY, "화"),
    WEDNESDAY(Calendar.WEDNESDAY, "수"),
    THURSDAY(Calendar.THURSDAY, "목"),
    FRIDAY(Calendar.FRIDAY, "금"),
    SATURDAY(Calendar.SATURDAY, "토"),
    SUNDAY(Calendar.SUNDAY, "일");

    companion object {
        fun create(day: Int): DayOfWeek {
            return values().first {
                it.day == day
            }
        }
    }
}