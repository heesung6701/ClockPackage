package com.quokkaman.android.app.common.data

abstract class AlarmSetting(open val active: Boolean) {

    abstract fun getTitle(): String
    fun getSummary(): String {
        return if (active) {
            getSummaryOn()
        } else {
            getSummaryOff()
        }
    }

    abstract fun getSummaryOn(): String
    private fun getSummaryOff(): String = "사용 안함 "
}