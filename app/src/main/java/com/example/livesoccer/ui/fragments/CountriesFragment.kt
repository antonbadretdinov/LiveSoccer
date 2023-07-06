package com.example.livesoccer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.livesoccer.R
import com.example.livesoccer.databinding.FragmentCountriesBinding
import com.example.livesoccer.helpers.extensions.hasInternetConnection


class CountriesFragment : Fragment() {

    private lateinit var binding: FragmentCountriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cardDenmark.setOnClickListener {
            if(activity?.hasInternetConnection() == false){
                Toast.makeText(activity, "No internet connection", Toast.LENGTH_SHORT).show()
            }else{
                val bundle = Bundle()
                bundle.putString("country", "Denmark")
                findNavController().navigate(R.id.action_countriesFragment_to_teamsFragment,bundle)
            }
        }

        binding.cardScotland.setOnClickListener {
            if(activity?.hasInternetConnection() == false){
                Toast.makeText(activity, "No internet connection", Toast.LENGTH_SHORT).show()
            }else {
                val bundle = Bundle()
                bundle.putString("country", "Scotland")
                findNavController().navigate(R.id.action_countriesFragment_to_teamsFragment, bundle)
            }
        }

        binding.btnApi.setOnClickListener {
            if(activity?.hasInternetConnection() == false){
                Toast.makeText(activity, "No internet connection", Toast.LENGTH_SHORT).show()
            }else {
                findNavController().navigate(R.id.action_countriesFragment_to_webFragment)
            }
        }
    }
}