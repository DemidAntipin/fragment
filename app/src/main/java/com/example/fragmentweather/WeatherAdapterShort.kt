package com.example.fragmentweather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WeatherAdapterShort(private val weatherList: List<String>) : RecyclerView.Adapter<WeatherAdapterShort.WeatherViewHolder>() {

    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tempTextView: TextView = view.findViewById(R.id.tv_temp)
        val dateTextView: TextView = view.findViewById(R.id.tv_date)
        val weatherImageView: ImageView = view.findViewById(R.id.img_weather)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_short, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherInfo = weatherList[position]
        val parts = weatherInfo.split(" - ")
        val date = parts[0].substringBefore(":")
        val temp = parts[0].substringAfter(": ").trim()
        val condition = parts[1].trim()

        holder.dateTextView.text = date
        holder.tempTextView.text = temp

        when (condition) {
            "Солнечно" -> holder.weatherImageView.setImageResource(R.drawable.sunny)
            "Дождь" -> holder.weatherImageView.setImageResource(R.drawable.rainy)
            "Облачно" -> holder.weatherImageView.setImageResource(R.drawable.cloudy)
            else -> holder.weatherImageView.setImageResource(R.drawable.cloudy)
        }
    }

    override fun getItemCount() = weatherList.size
}
