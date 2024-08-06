package com.example.heart2heart_1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heart2heart_1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var newsAdapter: NewsAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recyclerView : RecyclerView = binding.recyclerView
        newsAdapter = NewsAdapter(mutableListOf())
       recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = newsAdapter

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

       homeViewModel.articles.observe(viewLifecycleOwner, Observer { articles ->
           Log.d("HomeFragment", "Articles: ${articles.get(0).title}")
           newsAdapter.updateNewsList(articles)
       })

        homeViewModel.getArticles()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}