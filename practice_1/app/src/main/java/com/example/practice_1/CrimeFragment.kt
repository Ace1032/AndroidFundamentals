package com.example.practice_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice_1.databinding.FragmentCrimeBinding

class CrimeFragment : Fragment(),onClickListener {

    private lateinit var binding: FragmentCrimeBinding
    private lateinit var crimeAdapter: CrimeAdapter

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
        binding= FragmentCrimeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val crimes:List<Crime> = listOf(
            Crime(1, "Crime 1", "2021-01-01", true),
            Crime(2, "Crime 2", "2021-01-02", false),
            Crime(3, "Crime 3", "2021-01-03", true),
            Crime(4, "Crime 4", "2021-01-04", false),
            Crime(5, "Crime 5", "2021-01-05", true),
            Crime(6, "Crime 6", "2021-01-06", false),
            Crime(7, "Crime 7", "2021-01-07", true),
            Crime(8, "Crime 8", "2021-01-08", false),
            Crime(9, "Crime 9", "2021-01-09", true),
            Crime(10, "Crime 10", "2021-01-10", false),
            Crime(11, "Crime 11", "2021-01-11", true),
            Crime(12, "Crime 12", "2021-01-12", false),
            Crime(13, "Crime 13", "2021-01-13", true),
            Crime(14, "Crime 14", "2021-01-14", false),
            Crime(15, "Crime 15", "2021-01-15", true),
            Crime(16, "Crime 16", "2021-01-16", false),
            Crime(17, "Crime 17", "2021-01-17", true),
            Crime(18, "Crime 18", "2021-01-18", false),
            Crime(19, "Crime 19", "2021-01-19", true),
            Crime(20, "Crime 20", "2021-01-20", false),
            Crime(21, "Crime 21", "2021-01-21", true),
            Crime(22, "Crime 22", "2021-01-22", false),
            Crime(23, "Crime 23", "2021-01-23", true),
            Crime(24, "Crime 24", "2021-01-24", false),
            Crime(25, "Crime 25", "2021-01-25", true
        ))

        crimeAdapter= CrimeAdapter(crimes,this)
        binding.crimeRecyclerView.apply {
          layoutManager = LinearLayoutManager(context)
            adapter=crimeAdapter
        }

    }

    override fun onClick(crime: Crime) {

        Toast.makeText(context,"${crime.title} clicked",Toast.LENGTH_SHORT).show()
    }

}