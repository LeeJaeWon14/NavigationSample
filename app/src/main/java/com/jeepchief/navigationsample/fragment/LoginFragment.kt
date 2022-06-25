package com.jeepchief.navigationsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.jeepchief.navigationsample.R
import com.jeepchief.navigationsample.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    companion object {
        const val ID = "jeepchief"
        const val PW = "123"
    }
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.apply {
            btnLogin.setOnClickListener {
                if(
                    edtId.text.toString() == ID &&
                            edtPw.text.toString() == PW
                ) {
                    navController.navigate(R.id.action_loginFragment_to_successFragment)
                }
                else {
                    navController.navigate(R.id.action_loginFragment_to_failFragment)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}