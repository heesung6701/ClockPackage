package com.quokkaman.android.app.ui.edit

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.quokkaman.android.app.R
import com.quokkaman.android.app.common.data.*
import com.quokkaman.android.app.databinding.ActivityAlarmEditBinding
import com.quokkaman.android.app.ui.repeat.RepeatSettingActivity
import com.quokkaman.android.app.ui.sound.SoundSettingActivity
import com.quokkaman.android.app.ui.vibrate.VibrateSettingActivity
import java.util.*

class AlarmEditActivity : AppCompatActivity(), AlarmEditPresenter {

    private lateinit var viewModel: AlarmEditViewModel
    private lateinit var planViewModel: AlarmPlanViewModel
    private lateinit var soundSwitchModel: AlarmSettingSwitchModel
    private lateinit var repeatSwitchModel: AlarmSettingSwitchModel
    private lateinit var vibrateSwitchModel: AlarmSettingSwitchModel

    private val planViewModelFactory =
        AlarmPlanViewModel.Factory { listener, year, monthOfYear, dayOfMonth ->
            DatePickerDialog(this, listener, year, monthOfYear, dayOfMonth).apply {
                datePicker.minDate = Calendar.getInstance(Locale.KOREA).timeInMillis
                show()
            }
        }

    private val editViewModelFactory = AlarmEditViewModel.Factory(this)

    private val soundLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent = result.data ?: return@registerForActivityResult
                val sound =
                    data.getParcelableExtra<AlarmSound>("") ?: return@registerForActivityResult
                soundSwitchModel.settingLiveData.value = sound
            }
        }

    private val vibrateLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent = result.data ?: return@registerForActivityResult
                val vibrate =
                    data.getParcelableExtra<AlarmVibrate>("") ?: return@registerForActivityResult
                vibrateSwitchModel.settingLiveData.value = vibrate
            }
        }

    private val repeatLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent = result.data ?: return@registerForActivityResult
                val repeat =
                    data.getParcelableExtra<AlarmRepeat>("") ?: return@registerForActivityResult
                repeatSwitchModel.settingLiveData.value = repeat
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAlarmEditBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_alarm_edit)
        initViewModel()
        binding.viewModel = viewModel
        binding.planViewModel = planViewModel
        binding.repeatSwitchModel = repeatSwitchModel
        binding.soundSwitchModel = soundSwitchModel
        binding.vibrateSwitchModel = vibrateSwitchModel
        binding.lifecycleOwner = this
    }

    override fun generateAlarm(time: Time, name: String): Alarm {
        val plan = planViewModel.planLiveData.value
        val sound: AlarmSound =
            (soundSwitchModel.settingLiveData.value ?: AlarmSound(
                false,
                "",
                1.0f
            )) as AlarmSound
        val repeat: AlarmRepeat =
            (repeatSwitchModel.settingLiveData.value ?: AlarmRepeat(
                false,
                0,
                0
            )) as AlarmRepeat
        val vibrate: AlarmVibrate =
            (vibrateSwitchModel.settingLiveData.value ?: AlarmVibrate(
                false,
                AlarmVibrate.Type.None
            )) as AlarmVibrate
        return Alarm(
            time = time,
            name = name,
            plan = plan,
            soundSetting = sound,
            repeatSetting = repeat,
            vibrateSetting = vibrate,
            activate = true
        )
    }

    override fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this, editViewModelFactory).get(AlarmEditViewModel::class.java)
        planViewModel =
            ViewModelProvider(this, planViewModelFactory).get(AlarmPlanViewModel::class.java)

        soundSwitchModel =
            object : AlarmSettingSwitchModel(AlarmSound(false, "알람 이름", 0.5f)) {
                override fun onClick() {
                    soundLauncher.launch(
                        Intent(
                            applicationContext,
                            SoundSettingActivity::class.java
                        )
                    )
                }
            }
        repeatSwitchModel = object : AlarmSettingSwitchModel(AlarmRepeat(false, 1, 3)) {
            override fun onClick() {
                repeatLauncher.launch(
                    Intent(
                        applicationContext,
                        RepeatSettingActivity::class.java
                    )
                )
            }
        }
        vibrateSwitchModel = object :
            AlarmSettingSwitchModel(AlarmVibrate(false, AlarmVibrate.Type.BasicCall)) {
            override fun onClick() {
                vibrateLauncher.launch(
                    Intent(
                        applicationContext,
                        VibrateSettingActivity::class.java
                    )
                )
            }
        }
    }
    companion object {
        const val INTENT_ALARM = "alarm"
    }
}