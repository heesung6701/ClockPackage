package com.quokkaman.android.app.ui.alarm.edit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quokkaman.android.app.common.data.*
import java.util.*

class AlarmEditViewModel : ViewModel() {

    val alarmSoundSettingLiveData: LiveData<AlarmSetting> = MutableLiveData()
    val alarmVibrateSettingLiveData: LiveData<AlarmSetting> = MutableLiveData()
    val alarmRepeatSettingLiveData: LiveData<AlarmSetting> = MutableLiveData()
}