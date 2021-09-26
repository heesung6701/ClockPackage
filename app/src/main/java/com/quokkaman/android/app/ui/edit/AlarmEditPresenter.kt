package com.quokkaman.android.app.ui.edit

import com.quokkaman.android.app.common.data.Alarm
import com.quokkaman.android.app.common.data.Time

interface AlarmEditPresenter {

    fun generateAlarm(time: Time, name: String): Alarm

    fun finish()

    fun makeToast(text: String)
}