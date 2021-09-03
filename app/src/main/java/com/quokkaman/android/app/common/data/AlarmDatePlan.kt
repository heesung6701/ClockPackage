package com.quokkaman.android.app.common.data

import java.text.SimpleDateFormat
import java.util.*

class AlarmDatePlan(private val date: Date) : AlarmPlan {
    override fun valid(date: Date): Boolean {
        val sdf = SimpleDateFormat("yyMMdd", Locale.KOREA)
        return sdf.format(date) == sdf.format(this.date)
    }
}