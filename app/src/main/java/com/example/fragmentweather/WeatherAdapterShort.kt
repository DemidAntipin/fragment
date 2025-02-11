package com.example.fragmentweather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentweather.WeatherAdapterFull.WeatherViewHolder

class WeatherAdapterShort(private val weather: List<Weather_>) : RecyclerView.Adapter<WeatherAdapterShort.WeatherViewHolder>() {

    class WeatherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tempTextView: TextView = view.findViewById(R.id.tv_temp)
        val city: TextView = view.findViewById(R.id.city)
        val weatherImageView: ImageView = view.findViewById(R.id.img_weather)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_short, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherInfo = weather[position]
        when (weatherInfo.name) {
            "Irkutsk" -> holder.city.text = "Иркутск"
            "Paris" -> holder.city.text = "Париж"
            "London" -> holder.city.text = "Лондон"
            "Vikhorevka" -> holder.city.text = "Вихоревка"
            "Bratsk" -> holder.city.text = "Братск"
            "New York" -> holder.city.text = "Нью Йорк"
            "Moscow" -> holder.city.text = "Москва"
            else -> holder.city.text = "Нет данных"
        }
        holder.tempTextView.text = String.format("%.0f", (weatherInfo.main.temp)) + "°С"
        weatherInfo.wind.updateWindDirection(weatherInfo.wind.deg)
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
