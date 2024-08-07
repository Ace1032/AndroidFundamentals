package com.example.heart2heart_1.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heart2heart_1.MainActivity
import com.example.heart2heart_1.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var activityAdapter1: ActivitysAdapter1
    private lateinit var activityAdapter2: ActivityAdapter2

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dashboardViewModel =
            ViewModelProvider(requireActivity(),
                DashboardViewModelFactory((requireActivity() as MainActivity).repository))
                .get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView1 = binding.recyclerViewList1
        val recyclerView2 = binding.recyclerViewList2

        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView2.layoutManager = LinearLayoutManager(requireContext())

        activityAdapter1 = ActivitysAdapter1(mutableListOf())
        activityAdapter2 = ActivityAdapter2(mutableListOf())

        recyclerView1.adapter = activityAdapter1
        recyclerView2.adapter = activityAdapter2


        dashboardViewModel.myActivities.observe(viewLifecycleOwner) { activities ->
            activities?.let {
                activityAdapter2.updateActivityList(it)

            }
        }

        dashboardViewModel.upcomingActivities.observe(viewLifecycleOwner) { activities ->
            activities?.let {
                activityAdapter1.updateActivityList(it)

            }
        }
        dashboardViewModel.addMyActivities()
        dashboardViewModel.addUpcomingActivities()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}