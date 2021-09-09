package com.quokkaman.android.app.ui.alarm.edit

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.quokkaman.android.app.R
import com.quokkaman.android.app.databinding.ActivityAlarmEditBinding

class AlarmEditActivity : AppCompatActivity() {


    private lateinit var viewModel: AlarmEditViewModel
    private lateinit var planViewModel: AlarmPlanViewModel

    private val planViewModelFactory =
        AlarmPlanViewModel.AlarmPlanViewModelFactory { listener, year, monthOfYear, dayOfMonth ->
            DatePickerDialog(this, listener, year, monthOfYear, dayOfMonth).show()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAlarmEditBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_alarm_edit)
        viewModel = ViewModelProvider(this).get(AlarmEditViewModel::class.java)
        planViewModel =
            ViewModelProvider(this, planViewModelFactory).get(AlarmPlanViewModel::class.java)
        binding.viewModel = viewModel
        binding.planViewModel = planViewModel
        binding.lifecycleOwner = this

    }

    companion object {
        const val INTENT_ALARM = "alarm"
    }
}