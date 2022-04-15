package com.example.minichallengenetworkingretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.minichallengenetworkingretrofit.R
import com.example.minichallengenetworkingretrofit.model.GetAllCountryResponseItem
import kotlinx.android.synthetic.main.item_country_adapter.view.*

class CountryAdapter(private val listCountry : List<GetAllCountryResponseItem>) :
RecyclerView.Adapter<CountryAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        holder.itemView.country_name.text = listCountry[position].name
        holder.itemView.country_region.text = listCountry[position].region
        holder.itemView.country_population.text = listCountry[position].population.toString()
        Glide.with(holder.itemView.country_flag.context)
            .load(listCountry[position].flags.png)
            .override(200,100)
            .error(R.drawable.ic_launcher_background)
            .into(holder.itemView.country_flag)
    }

    override fun getItemCount(): Int {
        return listCountry.size
    }
}