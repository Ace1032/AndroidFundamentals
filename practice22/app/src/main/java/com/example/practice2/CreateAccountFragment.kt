package com.example.practice2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice2.databinding.FragmentCreateAccountBinding




class CreateAccountFragment : Fragment() {

    private var _binding:FragmentCreateAccountBinding?=null
    private val binding get()=_binding!!


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
        _binding=FragmentCreateAccountBinding.inflate(inflater,container,false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_create_account, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}

