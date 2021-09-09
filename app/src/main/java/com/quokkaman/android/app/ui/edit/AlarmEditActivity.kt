package com.quokkaman.android.app.ui.edit

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.quokkaman.android.app.R
import com.quokkaman.android.app.common.data.AlarmRepeat
import com.quokkaman.android.app.common.data.AlarmSound
import com.quokkaman.android.app.common.data.AlarmVibrate
import com.quokkaman.android.app.databinding.ActivityAlarmEditBinding
import java.util.*

class AlarmEditActivity : AppCompatActivity() {

    private lateinit var viewModel: AlarmEditViewModel
    private lateinit var planViewModel: AlarmPlanViewModel
    private lateinit var soundSettingViewModel: AlarmSettingViewModel
    private lateinit var repeatSettingViewModel: AlarmSettingViewModel
    private lateinit var vibrateSettingViewModel: AlarmSettingViewModel

    private val planViewModelFactory =
        AlarmPlanViewModel.AlarmPlanViewModelFactory { listener, year, monthOfYear, dayOfMonth ->
            DatePickerDialog(this, listener, year, monthOfYear, dayOfMonth).apply {
                datePicker.minDate = Calendar.getInstance(Locale.KOREA).timeInMillis
                show()
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAlarmEditBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_alarm_edit)
        viewModel = ViewModelProvider(this).get(AlarmEditViewModel::class.java)
        planViewModel =
            ViewModelProvider(this, planViewModelFactory).get(AlarmPlanViewModel::class.java)
        soundSettingViewModel = AlarmSettingViewModel().apply {
            settingLiveData.value = AlarmSound(false, "알람 이름", 0.5f)
        }
        repeatSettingViewModel = AlarmSettingViewModel().apply {
            settingLiveData.value = AlarmVibrate(false, AlarmVibrate.Type.BasicCall)
        }
        vibrateSettingViewModel = AlarmSettingViewModel().apply {
            settingLiveData.value = AlarmRepeat(false, 1, 3)
        }
        binding.viewModel = viewModel
        binding.planViewModel = planViewModel
        binding.repeatSettingViewModel = repeatSettingViewModel
        binding.soundSettingViewModel = soundSettingViewModel
        binding.vibrateSettingViewModel = vibrateSettingViewModel
        binding.lifecycleOwner = this
    }

    companion object {
        const val INTENT_ALARM = "alarm"
    }
}