package com.quokkaman.android.app.common.data

import java.lang.RuntimeException

class Time private constructor(val hour: Short, val minute: Short) {

    override fun toString(): String {
        return "${if(hour > 12) hour - 12 else hour}:$minute"
    }

    companion object {
        fun create(hour: Short, minute: Short) : Time {
            if (hour !in 0..23) throw RuntimeException("Invalid hour: $hour")
            if (minute !in 0 until 60) throw RuntimeException("Invalid minute: $minute")
            return Time(hour, minute)
        }
    }
}
