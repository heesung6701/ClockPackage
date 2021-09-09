package com.quokkaman.android.app.ui.edit

import androidx.lifecycle.MutableLiveData
import com.quokkaman.android.app.common.data.AlarmSetting

class AlarmSettingViewModel {

    val settingLiveData: MutableLiveData<AlarmSetting> = MutableLiveData()

    fun toggle() {
        val setting = settingLiveData.value ?: return
        setting.active = !setting.active
        settingLiveData.value = setting
    }
}