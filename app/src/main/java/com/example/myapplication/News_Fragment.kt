package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentNewsBinding


class News_Fragment : Fragment() {

    private lateinit var news_list: MutableList<newsData>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        news_list = mutableListOf()
        for (i in 0..15)
        {
            news_list.add(newsData(R.drawable.news_demo, "Kiyev: Qrim bo‘yicha muzokaralar qarshi hujumdan keyin o‘tkazilishi mumkin"))
            news_list.add(newsData(R.drawable.news_demo2, "AEXA rahbari Kaliningradda Zaporijjya AES xavfsizligini muhokama qildi"))
            news_list.add(newsData(R.drawable.news_demo3, "Rossiyada ukrainlarning yengil motorli samolyoti halokatga uchradi, uchuvchi hibsga olingan"))
        }
        val binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.recy.setHasFixedSize(true)
        binding.recy.adapter = Adapter(news_list, object : Adapter.MyNews {
            override fun onItemClick(newsData: newsData) {
                val bundle = bundleOf("news" to newsData)
                findNavController().navigate(R.id.action_news_Fragment_to_news_Detailed_Fragment, bundle)
            }

        })
        return binding.root
    }
}