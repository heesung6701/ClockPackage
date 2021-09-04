package com.quokkaman.android.app.common.data

data class AlarmRepeat(override val active: Boolean, val interval: Int, val repeat: Int) :
    AlarmSetting(active) {
    override fun getTitle(): String = "다시 울림"

    override fun getSummaryOn(): String = "${interval}분 ${repeat}회"
}