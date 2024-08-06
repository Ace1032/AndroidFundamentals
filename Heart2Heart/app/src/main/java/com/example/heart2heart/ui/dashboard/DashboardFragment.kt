package com.example.heart2heart.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heart2heart.R
import com.example.heart2heart.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView1 = binding.recyclerView1
        val recyclerView2 = binding.recyclerView2

        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView2.layoutManager = LinearLayoutManager(requireContext())

        val adapter1 = MyAdapter1(getDataForFirstRecyclerView())
        val adapter2 = MyAdapter1(getDataForSecondRecyclerView())

        recyclerView1.adapter= adapter1
        recyclerView2.adapter= adapter2
    }

    private fun getDataForFirstRecyclerView(): List<Event> {
        return listOf(
            Event("Title 1", "Date 1", R.drawable.ic_home_black_24dp),
            Event("Title 2", "Date 2", R.drawable.ic_home_black_24dp),
            Event("Title 3", "Date 3", R.drawable.ic_home_black_24dp))
    }
    private fun getDataForSecondRecyclerView(): List<Event> {
        return listOf(
            Event("Title 4", "Date 1", R.drawable.ic_home_black_24dp),
            Event("Title 5", "Date 2", R.drawable.ic_home_black_24dp),
            Event("Title 6", "Date 3", R.drawable.ic_home_black_24dp))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}