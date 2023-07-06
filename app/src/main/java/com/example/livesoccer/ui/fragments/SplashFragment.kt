package com.example.livesoccer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.livesoccer.R
import com.example.livesoccer.databinding.FragmentSplashBinding
import com.example.livesoccer.helpers.extensions.hasInternetConnection
import com.example.livesoccer.viewmodels.MainViewModel

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    private val countriesViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        countriesViewModel.denmarkTeamsLiveData.observe(activity as LifecycleOwner){
            findNavController().navigate(R.id.action_splashFragment_to_countriesFragment)
        }

        if(activity?.hasInternetConnection() == true){
            countriesViewModel.getScotlandList()
            countriesViewModel.geDenmarkList()
        }else{
            Toast.makeText(activity, "No internet connection", Toast.LENGTH_SHORT).show()
            binding.progressBar.visibility = View.INVISIBLE
            binding.tryAgainBtn.visibility = View.VISIBLE
        }


        binding.tryAgainBtn.setOnClickListener {
            if(activity?.hasInternetConnection() == true){
                countriesViewModel.getScotlandList()
                countriesViewModel.geDenmarkList()
                binding.tryAgainBtn.visibility = View.INVISIBLE
                binding.progressBar.visibility = View.VISIBLE
            }else{
                Toast.makeText(activity, "No internet connection", Toast.LENGTH_SHORT).show()
            }
        }

    }
}