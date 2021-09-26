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
    private lateinit var soundSettingViewModel: AlarmSettingViewModel
    private lateinit var repeatSettingViewModel: AlarmSettingViewModel
    private lateinit var vibrateSettingViewModel: AlarmSettingViewModel

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
                val vibrate =
                    data.getParcelableExtra<AlarmSound>("") ?: return@registerForActivityResult
                soundSettingViewModel.settingLiveData.value = vibrate
            }
        }

    private val vibrateLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent = result.data ?: return@registerForActivityResult
                val vibrate =
                    data.getParcelableExtra<AlarmVibrate>("") ?: return@registerForActivityResult
                vibrateSettingViewModel.settingLiveData.value = vibrate
            }
        }

    private val repeatLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent = result.data ?: return@registerForActivityResult
                val repeat =
                    data.getParcelableExtra<AlarmRepeat>("") ?: return@registerForActivityResult
                repeatSettingViewModel.settingLiveData.value = repeat
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAlarmEditBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_alarm_edit)
        initViewModel()
        binding.viewModel = viewModel
        binding.planViewModel = planViewModel
        binding.repeatSettingViewModel = repeatSettingViewModel
        binding.soundSettingViewModel = soundSettingViewModel
        binding.vibrateSettingViewModel = vibrateSettingViewModel
        binding.lifecycleOwner = this
    }

    override fun generateAlarm(time: Time, name: String): Alarm {
        val plan = planViewModel.planLiveData.value
        val sound: AlarmSound =
            (soundSettingViewModel.settingLiveData.value ?: AlarmSound(
                false,
                "",
                1.0f
            )) as AlarmSound
        val repeat: AlarmRepeat =
            (repeatSettingViewModel.settingLiveData.value ?: AlarmRepeat(
                false,
                0,
                0
            )) as AlarmRepeat
        val vibrate: AlarmVibrate =
            (vibrateSettingViewModel.settingLiveData.value ?: AlarmVibrate(
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
        viewModel = ViewModelProvider(this, editViewModelFactory).get(AlarmEditViewModel::class.java)
        planViewModel =
            ViewModelProvider(this, planViewModelFactory).get(AlarmPlanViewModel::class.java)
        soundSettingViewModel = AlarmSettingViewModel {
            soundLauncher.launch(
                Intent(
                    this,
                    SoundSettingActivity::class.java
                )
            )
        }.apply {
            settingLiveData.value = AlarmSound(false, "알람 이름", 0.5f)
        }
        repeatSettingViewModel = AlarmSettingViewModel {
            repeatLauncher.launch(
                Intent(
                    this,
                    RepeatSettingActivity::class.java
                )
            )
        }.apply {
            settingLiveData.value = AlarmRepeat(false, 1, 3)
        }
        vibrateSettingViewModel = AlarmSettingViewModel {
            vibrateLauncher.launch(Intent(this, VibrateSettingActivity::class.java))
        }.apply {
            settingLiveData.value = AlarmVibrate(false, AlarmVibrate.Type.BasicCall)
        }
    }
    companion object {
        const val INTENT_ALARM = "alarm"
    }
}