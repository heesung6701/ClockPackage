package com.quokkaman.android.app.ui.alarm.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quokkaman.android.app.common.data.AlarmPlan
import com.quokkaman.android.app.common.data.DayOfWeek

class AlarmPlanViewModel : ViewModel() {

    public val alarmPlanLiveData : LiveData<AlarmPlan> = MutableLiveData()

    public val titleLiveData: LiveData<String> = MutableLiveData()

    public fun clickDate() {

    }

    public fun clickDay(dayOfWeek: DayOfWeek) {

    }
}