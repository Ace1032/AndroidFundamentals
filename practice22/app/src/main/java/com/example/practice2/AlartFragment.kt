package com.example.practice2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.example.practice2.databinding.FragmentAlartBinding

class AlartFragment : Fragment() {
    private var _binding: FragmentAlartBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAlartBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createAccount.setOnClickListener {
            val craeteAccount:CreateAccountFragment= CreateAccountFragment()

            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.container,
                craeteAccount
            ).commit()
            //Toast.makeText(requireContext(), "Create Account!", Toast.LENGTH_LONG).show()
        }


        binding.aboutme.setOnClickListener {
            val aboutme: aboutmeFragment= aboutmeFragment()
            requireActivity().supportFragmentManager.beginTransaction().replace(
            R.id.container,
                aboutme
            ).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}