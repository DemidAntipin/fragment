package com.example.fragmentweather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentweather.WeatherAdapterShort.WeatherViewHolder

class WeatherAdapterFull(private val weather: List<Weather_>, context: Context) : RecyclerView.Adapter<WeatherAdapterFull.WeatherViewHolder>() {
    private val cities = context.resources.getStringArray(R.array.cities_names)
    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tempTextView: TextView = view.findViewById(R.id.tv_temp)
        val city: TextView = view.findViewById(R.id.city)
        val weatherImageView: ImageView = view.findViewById(R.id.img_weather)
        val weather_humidity: TextView = view.findViewById(R.id.tv_humidity)
        val wind: TextView = view.findViewById(R.id.wind)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_full, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherInfo = weather[position]
        when (weatherInfo.name) {
            "Irkutsk" -> holder.city.text = cities[0]
            "Paris" -> holder.city.text = cities[1]
            "London" -> holder.city.text = cities[2]
            "New York" -> holder.city.text = cities[3]
            else -> holder.city.text = weatherInfo.name
        }
        holder.tempTextView.text = String.format("%.0f", (weatherInfo.main.temp)) + "°С"
        holder.wind.text=weatherInfo.wind.direction
        holder.weather_humidity.text=(weatherInfo.main.humidity).toString() + '%'
        when (weatherInfo.weather[0].main) {
            "Clear" -> holder.weatherImageView.setImageResource(R.drawable.sunny)
            "Rain" -> holder.weatherImageView.setImageResource(R.drawable.rainy)
            "Drizzle" -> holder.weatherImageView.setImageResource(R.drawable.rainy)
            "Thunderstorm" -> holder.weatherImageView.setImageResource(R.drawable.storm)
            "Snow" -> holder.weatherImageView.setImageResource(R.drawable.snowy)
            "Mist" -> holder.weatherImageView.setImageResource(R.drawable.foggy)
            "Fog" -> holder.weatherImageView.setImageResource(R.drawable.foggy)
            "Clouds" -> holder.weatherImageView.setImageResource(R.drawable.cloudy)
            else -> holder.weatherImageView.setImageResource(R.drawable.sunny)
        }
    }

    override fun getItemCount() = weather.size
}