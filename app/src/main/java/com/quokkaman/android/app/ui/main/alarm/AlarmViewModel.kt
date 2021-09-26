package com.quokkaman.android.app.ui.main.alarm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quokkaman.android.app.common.data.Alarm
import com.quokkaman.android.app.common.repository.AlarmRepository
import com.quokkaman.android.app.common.repository.AlarmRepositoryImpl

class AlarmViewModel : ViewModel() {

    val alarmListLiveData : MutableLiveData<List<Alarm>> = MutableLiveData()

    init {
        val repo : AlarmRepository = AlarmRepositoryImpl()
        alarmListLiveData.value = repo.getDummyAlarmList(20)
    }
}