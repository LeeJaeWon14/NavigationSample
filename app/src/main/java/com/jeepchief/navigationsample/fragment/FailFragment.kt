package com.jeepchief.navigationsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.jeepchief.navigationsample.R
import com.jeepchief.navigationsample.databinding.FragmentFailBinding

class FailFragment : Fragment() {
    private var _binding: FragmentFailBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.apply {
            btnBack.setOnClickListener {
                navController.navigate(R.id.action_failFragment_to_mainFragment2)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}