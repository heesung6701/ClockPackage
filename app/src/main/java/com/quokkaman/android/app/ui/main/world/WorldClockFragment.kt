package com.quokkaman.android.app.ui.main.world

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quokkaman.android.app.R

class WorldClockFragment : Fragment() {

    companion object {
        fun newInstance() = WorldClockFragment()
    }

    private lateinit var viewModel: WorldClockViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.world_clock_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WorldClockViewModel::class.java)
        // TODO: Use the ViewModel
    }

}