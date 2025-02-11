package com.example.fragmentweather

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

class WeatherFull : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapterFull

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather_full, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewWeather)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val weatherData = WeatherDataHolder.weatherData
        weatherAdapter = WeatherAdapterFull(weatherData)
        recyclerView.adapter = weatherAdapter
        return view
    }
}