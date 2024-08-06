package com.example.practice2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView


class HomeFragment : Fragment() {


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
        val view= inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<CardView>(R.id.running_cardview)?.setOnClickListener {
            // Navigate to another fragment or perform action
            var runningFragment: RunningFragment= RunningFragment()
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.container, runningFragment).commit()
        }

        view.findViewById<CardView>(R.id.report_cardview)?.setOnClickListener{
            var healthReportFragment:HealthReportFragment= HealthReportFragment()
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.container,healthReportFragment).commit()
        }

        view.findViewById<CardView>(R.id.lifting_cardview)?.setOnClickListener {
            var weightlyftingFragment: WeightlyftingFragment= WeightlyftingFragment()
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.container, weightlyftingFragment).commit()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


}