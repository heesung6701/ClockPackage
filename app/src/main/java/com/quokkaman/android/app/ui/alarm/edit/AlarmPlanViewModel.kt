package com.quokkaman.android.app.ui.alarm.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.quokkaman.android.app.common.data.AlarmDatePlan
import com.quokkaman.android.app.common.data.AlarmDayPlan
import com.quokkaman.android.app.common.data.AlarmPlan
import com.quokkaman.android.app.common.data.DayOfWeek
import java.util.*

class AlarmPlanViewModel : ViewModel() {

    val planLiveData = MutableLiveData<AlarmPlan>().apply { value = AlarmDatePlan(Date()) }

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

    fun makeIsDayLiveData(dayOfWeek: DayOfWeek): LiveData<Boolean> {
        return Transformations.map(planLiveData) { plan ->
            if (plan !is AlarmDayPlan) {
                false
            } else {
                plan.contains(dayOfWeek)
            }
        }
    }
}