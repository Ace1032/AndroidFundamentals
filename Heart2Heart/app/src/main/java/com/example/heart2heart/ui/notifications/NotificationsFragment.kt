package com.example.heart2heart.ui.notifications

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.heart2heart.R
import com.example.heart2heart.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.loginButton.setOnClickListener {
            loginFragment()
        }
        binding.registerButton.setOnClickListener {
            registerFragment()
        }

        return root
    }

    private fun registerFragment() {
       findNavController().navigate(R.id.registerFragment)
    }

    private fun loginFragment(){
        val navController = findNavController()
        navController.navigate(R.id.loginFragment)

        }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}