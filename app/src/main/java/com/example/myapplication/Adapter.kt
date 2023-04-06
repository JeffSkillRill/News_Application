package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.databinding.NewsItemBinding

class Adapter(var news: MutableList<newsData>, var myNews: MyNews): RecyclerView.Adapter<Adapter.MyHolder>() {
    class MyHolder(binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var heading = binding.text
        var img = binding.image
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var new = news[position]
        holder.heading.text = new.news_data
        holder.img.setImageResource(new.image)

        holder.itemView.setOnClickListener {
            myNews.onItemClick(new)
        }
    }
    interface MyNews{
        fun onItemClick(newsData: newsData)
    }
}