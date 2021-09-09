package com.quokkaman.android.app.ui.edit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.quokkaman.android.app.common.data.Time

class AlarmEditViewModel(private val editPresenter: AlarmEditPresenter) : ViewModel() {

    val timeLiveData = MutableLiveData<Time>()
    val titleLiveData = MutableLiveData<String>()

    val updateTime = fun (time: Time) {
        timeLiveData.value = time
    }

    init {
        timeLiveData.value = Time.create(6, 0)
    }

    fun onCancel() {
        editPresenter.finish()
    }

    fun onSave() {
        val time = timeLiveData.value ?: return
        val title = titleLiveData.value ?: ""
        val alarm = editPresenter.generateAlarm(time, title)
        editPresenter.makeToast(alarm.toString())
        editPresenter.finish()
    }

    class Factory(private val editPresenter: AlarmEditPresenter) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            AlarmEditViewModel(editPresenter) as T
    }
    companion object {
        private val TAG = this::class.java.simpleName
    }
}