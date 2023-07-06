package com.example.livesoccer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.livesoccer.databinding.FragmentScheduleBinding
import com.example.livesoccer.ui.adapters.ScheduleAdapter
import com.example.livesoccer.viewmodels.MainViewModel

class ScheduleFragment : Fragment() {

    private lateinit var binding: FragmentScheduleBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScheduleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding){
            recyclerSchedule.layoutManager = LinearLayoutManager(context)
            tvTeamName.text = arguments?.getString("teamName")
            Glide.with(this@ScheduleFragment).load(
                arguments?.getString("teamLogo")).into(imageTeamLogo)
        }


        viewModel.scheduleLiveData.observe(activity as LifecycleOwner){schedule ->
            binding.recyclerSchedule.adapter = arguments?.getInt("teamId")?.let {
                    id -> ScheduleAdapter(schedule, id)
            }
        }
    }
}