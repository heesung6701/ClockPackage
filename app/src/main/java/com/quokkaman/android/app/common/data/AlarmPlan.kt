package com.quokkaman.android.app.common.data

import java.util.*

interface AlarmPlan {
    fun valid(date: Date): Boolean
    fun getTitle(): String
}