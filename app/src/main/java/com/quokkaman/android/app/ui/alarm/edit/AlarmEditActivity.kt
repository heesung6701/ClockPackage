package com.quokkaman.android.app.ui.alarm.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.quokkaman.android.app.R
import com.quokkaman.android.app.common.data.AlarmPlan
import com.quokkaman.android.app.databinding.ActivityAlarmEditBinding

class AlarmEditActivity : AppCompatActivity() {


    private lateinit var viewModel : AlarmEditViewModel
    private lateinit var planViewModel : AlarmPlanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAlarmEditBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_alarm_edit)
        viewModel = ViewModelProvider(this).get(AlarmEditViewModel::class.java)
        planViewModel = ViewModelProvider(this).get(AlarmPlanViewModel::class.java)
        binding.viewModel = viewModel
        binding.planViewModel = planViewModel
        binding.lifecycleOwner = this
    }

    companion object {
        const val INTENT_ALARM = "alarm"
    }
}