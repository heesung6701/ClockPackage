package com.quokkaman.android.app.common.data

import java.text.SimpleDateFormat
import java.util.*

class AlarmDatePlan(private val date: Date) : AlarmPlan {

    override fun valid(date: Date): Boolean {
        val sdf = SimpleDateFormat("yyMMdd", Locale.KOREA)
        return sdf.format(date) == sdf.format(this.date)
    }

    override fun getTitle(): String {
        val dateFormat = SimpleDateFormat("MM월 dd일 (E)", Locale.KOREA)

        val calendar = Calendar.getInstance(Locale.KOREA)
        val todayStr = dateFormat.format(calendar.time)
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        val tomorrowStr = dateFormat.format(calendar.time)
        val dateStr = dateFormat.format(date.time)
        return when(dateStr) {
            todayStr -> "오늘 - "
            tomorrowStr -> "내일 - "
            else -> ""
        } + dateStr
    }
}