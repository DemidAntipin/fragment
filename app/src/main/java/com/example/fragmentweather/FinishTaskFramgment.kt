package com.example.fragmentweather

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.fragmentweather.MainActivity

class WeatherFull(city: String, context: Context) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapterFull
    private val selectedcity = city
    private val cntx = context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather_full, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewWeather)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val weatherData = when(selectedcity){
            "Irkutsk" -> WeatherDataHolder.weatherDataIrkutsk
            "Paris" -> WeatherDataHolder.weatherDataParis
            "London" -> WeatherDataHolder.weatherDataLondon
            "New York" -> WeatherDataHolder.weatherDataNewYork
            else -> throw Exception("Unknown city")
        }
        weatherAdapter = WeatherAdapterFull(weatherData, cntx)
        recyclerView.adapter = weatherAdapter
        return view
    }
}