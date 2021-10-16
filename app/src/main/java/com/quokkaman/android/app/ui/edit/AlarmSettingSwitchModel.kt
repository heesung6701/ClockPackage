package com.quokkaman.android.app.ui.edit

import androidx.lifecycle.MutableLiveData
import com.quokkaman.android.app.common.data.AlarmSetting

abstract class AlarmSettingSwitchModel(alarmSetting: AlarmSetting) {

    val settingLiveData: MutableLiveData<AlarmSetting> = MutableLiveData(alarmSetting)
    val enabledLiveData = MutableLiveData<Boolean>()

    fun toggle() {
        val setting = settingLiveData.value ?: return
        setting.active = !setting.active
        settingLiveData.value = setting
        onActivateChanged(setting.active)
    }

    open fun onActivateChanged(activate: Boolean) {

    }

    abstract fun onClick()
}