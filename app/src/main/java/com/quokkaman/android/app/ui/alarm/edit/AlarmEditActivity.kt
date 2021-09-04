package com.quokkaman.android.app.ui.alarm.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.quokkaman.android.app.R
import com.quokkaman.android.app.databinding.ActivityAlarmEditBinding

class AlarmEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAlarmEditBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_alarm_edit)
        binding.viewModel = ViewModelProvider(this).get(AlarmEditViewModel::class.java)
        binding.planViewModel = ViewModelProvider(this).get(AlarmPlanViewModel::class.java)
    }

    companion object {
        const val INTENT_ALARM = "alarm"
    }
}