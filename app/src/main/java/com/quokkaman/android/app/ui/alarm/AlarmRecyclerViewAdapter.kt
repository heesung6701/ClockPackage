package com.quokkaman.android.app.ui.alarm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.quokkaman.android.app.R
import com.quokkaman.android.app.common.data.Alarm
import com.quokkaman.android.app.databinding.AlarmListItemBinding

class AlarmRecyclerViewAdapter : ListAdapter<Alarm, AlarmRecyclerViewAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: AlarmListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.alarm_list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    
    inner class ViewHolder(private val binding: AlarmListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(alarm: Alarm) {
            binding.alarm = alarm
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Alarm>() {
            override fun areContentsTheSame(oldItem: Alarm, newItem: Alarm) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Alarm, newItem: Alarm) =
                oldItem == newItem
        }
    }
}