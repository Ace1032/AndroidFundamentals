package com.example.newsapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.newsModel.Article
import com.example.newsapp.newsModel.NewsApi
import com.example.newsapp.newsModel.NewsRepository
import com.example.newsapp.newsModel.NewsService


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var newsRepository:NewsRepository
    private lateinit var artcles: List<Article>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        newsRepository= NewsRepository()
        val factory = HomeViewModelFactory(newsRepository)
        val homeViewModel =
            ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        homeViewModel.live_articles.observe(viewLifecycleOwner){
            artcles=it
        }

        homeViewModel.fetchNews()
        Log.d("Print article data", artcles.get(0).title.toString())
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("trace fail", "HomeFragment->onViewCreated")
        homeViewModel.fetchNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}