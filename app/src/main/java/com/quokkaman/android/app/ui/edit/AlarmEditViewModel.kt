package com.quokkaman.android.app.ui.edit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.quokkaman.android.app.common.data.Alarm
import com.quokkaman.android.app.common.data.Time

class AlarmEditViewModel(val generator: (Time, String) -> Alarm) : ViewModel() {


    fun onCancel() {
    }

    fun onSave() {
        val alarm = generator(Time.create(1, 0), "")
        Log.d(TAG, alarm.toString())
    }

    class Factory(private val generator: (Time, String) -> Alarm) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            AlarmEditViewModel(generator) as T
    }
    companion object {
        private val TAG = this::class.java.simpleName
    }
}