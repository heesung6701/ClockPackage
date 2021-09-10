package com.quokkaman.android.app.ui.alarm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quokkaman.android.app.R
import com.quokkaman.android.app.databinding.AlarmFragmentBinding

class AlarmFragment : Fragment() {

    companion object {
        fun newInstance() = AlarmFragment()
    }

    private lateinit var viewModel: AlarmViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alarm_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = AlarmFragmentBinding.bind(view)

        viewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)
        binding.alarmViewModel = viewModel
        binding.lifecycleOwner = this
    }
}