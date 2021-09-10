package com.quokkaman.android.app.ui.alarm.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quokkaman.android.app.common.data.*
import java.util.*

class AlarmEditViewModel : ViewModel() {

    val planLiveData = MutableLiveData<AlarmPlan>().apply { value = AlarmDatePlan(Date()) }

    val alarmSoundSettingLiveData: LiveData<AlarmSetting> = MutableLiveData()
    val alarmVibrateSettingLiveData: LiveData<AlarmSetting> = MutableLiveData()
    val alarmRepeatSettingLiveData: LiveData<AlarmSetting> = MutableLiveData()

    fun clickDate() {
        val alarmDatePlan = AlarmDatePlan(Date())
        planLiveData.postValue(alarmDatePlan)
    }

    fun clickDay(dayOfWeek: DayOfWeek) {
        val prevPlan = planLiveData.value
        val alarmPlan = if (prevPlan !is AlarmDayPlan) {
            AlarmDayPlan(EnumSet.of(dayOfWeek), false)
        } else {
            prevPlan.toggle(dayOfWeek)
            if (prevPlan.isEmpty()) {
                AlarmDatePlan(Date())
            } else {
                prevPlan
            }
        }
        planLiveData.postValue(alarmPlan)
    }
}