package com.quokkaman.android.app.ui.main.alarm

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.quokkaman.android.app.R
import com.quokkaman.android.app.common.data.Alarm
import com.quokkaman.android.app.common.data.AlarmDayPlan
import com.quokkaman.android.app.common.data.AlarmPlan
import com.quokkaman.android.app.common.data.DayOfWeek

object AlarmDataBindingUtils {

    @BindingAdapter("setAlarmList")
    @JvmStatic
    fun setAlarmList(recyclerView: RecyclerView, items: List<Alarm>) {
        if (recyclerView.adapter == null) {
            val adapter = AlarmRecyclerViewAdapter()
            recyclerView.adapter = adapter
        }
        val adapter = recyclerView.adapter as AlarmRecyclerViewAdapter
        adapter.submitList(items.toMutableList())
    }

    @BindingAdapter("setPlan", "setDay")
    @JvmStatic
    fun setDayPlan(textView: TextView, plan: AlarmPlan?, day: DayOfWeek) {
        if (plan !is AlarmDayPlan) return
        val color = if (plan.contains(day)) ContextCompat.getColor(
            textView.context,
            R.color.design_default_color_primary
        )
        else ContextCompat.getColor(textView.context, android.R.color.tab_indicator_text)

        textView.setTextColor(color)
        textView.compoundDrawables.forEach {
            it?.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
        }
    }
}