package com.example.practice2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import  com.example.practice2.databinding.FragmentAboutmeBinding

class aboutmeFragment : Fragment() {

    private var _binding:FragmentAboutmeBinding?=null
    private val binding get()= _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentAboutmeBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.emailId.setOnClickListener {
            Toast.makeText(requireContext(),"email",Toast.LENGTH_LONG).show()
        }

        binding.phoneId.setOnClickListener {
            val phone_number=binding.phoneId.text.toString().trim()
            dialPhoneNumber(phone_number)
        }
        binding.emailId.setOnClickListener {
            val email_address=binding.emailId.text.toString().trim()
            composeemail(email_address)
        }
    }

    private fun composeemail(emailAddress: String) {
            val send_mail=Intent(Intent.ACTION_SENDTO).apply {
                data= Uri.parse("mailto:$emailAddress")
            }
            startActivity(send_mail)
    }

    private fun dialPhoneNumber(phoneNumber: String) {
            val dial= Intent(Intent.ACTION_DIAL).apply {
                data= Uri.parse("tel:$phoneNumber")
            }
            startActivity(dial)
    }

}