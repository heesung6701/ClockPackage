package com.quokkaman.android.app.ui.edit

import android.widget.TimePicker
import androidx.databinding.BindingAdapter
import com.quokkaman.android.app.common.data.Time
import java.util.function.Consumer

object EditDataBindingUtils {

    @BindingAdapter("onUpdateTime")
    @JvmStatic
    fun setTimeChangeListener(timePicker: TimePicker, timeConsumer: (time: Time) -> Unit) {
        timePicker.setOnTimeChangedListener { _, hour, minute ->
            timeConsumer(Time.create(hour.toShort(), minute.toShort()))
        }
    }

    @BindingAdapter("setTime")
    @JvmStatic
    fun setTime(timePicker: TimePicker, time: Time) {
        timePicker.hour = time.hour.toInt()
        timePicker.minute = time.minute.toInt()
    }
}