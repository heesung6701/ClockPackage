package com.quokkaman.android.app.ui.edit

import androidx.lifecycle.MutableLiveData
import com.quokkaman.android.app.common.data.AlarmSetting

class AlarmSettingViewModel(private val startActivity: () -> Unit) {

    val settingLiveData: MutableLiveData<AlarmSetting> = MutableLiveData()

    fun toggle() {
        val setting = settingLiveData.value ?: return
        setting.active = !setting.active
        settingLiveData.value = setting
    }

    fun onClick() {
        startActivity()
    }
}