package com.quokkaman.android.app.alarm.common.data

import java.lang.RuntimeException

data class Time private constructor(val hour: Short, val minute: Short) {

    companion object {
        fun create(hour: Short, minute: Short) : Time {
            if (hour !in 1..24) throw RuntimeException("Invalid hour: $hour")
            if (minute !in 0 until 60) throw RuntimeException("Invalid minute: $minute")
            return Time(hour, minute)
        }
    }
}
