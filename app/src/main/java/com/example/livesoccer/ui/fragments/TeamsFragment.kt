package com.example.livesoccer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livesoccer.R
import com.example.livesoccer.databinding.FragmentTeamsBinding
import com.example.livesoccer.helpers.extensions.hasInternetConnection
import com.example.livesoccer.model.TeamModel
import com.example.livesoccer.ui.adapters.TeamsAdapter
import com.example.livesoccer.ui.adapters.listener.SelectListener
import com.example.livesoccer.viewmodels.MainViewModel

class TeamsFragment : Fragment(), SelectListener {

    private lateinit var binding: FragmentTeamsBinding
    private val teamsViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerTeams.layoutManager = LinearLayoutManager(context)
        when(arguments?.getString("country")){
            "Scotland" ->{
                teamsViewModel.scotlandTeamsLiveData.observe(viewLifecycleOwner){
                    binding.recyclerTeams.adapter = TeamsAdapter(it,this)
                }
            }
            "Denmark" ->{
                teamsViewModel.denmarkTeamsLiveData.observe(viewLifecycleOwner){
                    binding.recyclerTeams.adapter = TeamsAdapter(it,this)
                }
            }
        }
    }

    override fun onItemClicked(model: TeamModel) {
        if(activity?.hasInternetConnection() == false){
            Toast.makeText(activity, "No internet connection", Toast.LENGTH_SHORT).show()
        }else {
            val bundle = Bundle()
            bundle.putString("teamName", model.name)
            bundle.putString("teamLogo", model.image_path)
            bundle.putInt("teamId", model.id)
            teamsViewModel.getTeamSchedule(model.id)
            findNavController().navigate(R.id.action_teamsFragment_to_scheduleFragment, bundle)
        }
    }


}