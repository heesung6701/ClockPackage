package com.quokkaman.android.app.ui.main.stopwatch

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quokkaman.android.app.R

class StopWatchFragment : Fragment() {

    companion object {
        fun newInstance() = StopWatchFragment()
    }

    private lateinit var viewModel: StopWatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stop_watch_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StopWatchViewModel::class.java)
        // TODO: Use the ViewModel
    }
}