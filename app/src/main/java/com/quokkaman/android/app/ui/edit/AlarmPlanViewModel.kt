package com.quokkaman.android.app.ui.edit

import android.app.DatePickerDialog
import androidx.lifecycle.*
import com.quokkaman.android.app.common.data.AlarmDatePlan
import com.quokkaman.android.app.common.data.AlarmDayPlan
import com.quokkaman.android.app.common.data.AlarmPlan
import com.quokkaman.android.app.common.data.DayOfWeek
import java.util.*


class AlarmPlanViewModel(val openDatePickerDialog: (DatePickerDialog.OnDateSetListener, Int, Int, Int) -> Unit) :
    ViewModel() {

    val planLiveData = MutableLiveData<AlarmPlan>().apply { value = AlarmDatePlan(Date()) }

    fun clickDate() {
        val calendar = Calendar.getInstance(Locale.KOREA)

        openDatePickerDialog(
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                planLiveData.value = AlarmDatePlan(calendar.time)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
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

    class Factory(private val openDatePickerDialog: (DatePickerDialog.OnDateSetListener, Int, Int, Int) -> Unit) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            AlarmPlanViewModel(openDatePickerDialog) as T
    }
}