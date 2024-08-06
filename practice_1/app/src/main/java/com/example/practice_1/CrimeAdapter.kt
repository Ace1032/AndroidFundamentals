package com.example.practice_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice_1.CrimeAdapter.CrimeHolder
import com.example.practice_1.databinding.ItemCrimeBinding

class CrimeAdapter(private val crimes:List<Crime>, private val clickListener: onClickListener) : RecyclerView.Adapter<CrimeHolder>() {

    private lateinit var binding: ItemCrimeBinding

    inner class CrimeHolder(binding:ItemCrimeBinding) :RecyclerView.ViewHolder(binding.root){

                fun bind(crime: Crime){
                    binding.crimeTitle.text=crime.title
                    binding.crimeImageView.setImageResource(R.drawable.image1)
                }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        binding=ItemCrimeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CrimeHolder(binding)
    }

    override fun getItemCount(): Int {
        return crimes.size
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        //holder.bind(crimes[position])
        val crime=crimes[position]
        holder.bind(crime)
        holder.itemView.setOnClickListener{
            clickListener.onClick(crime)
        }
    }


}