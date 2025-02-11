package com.example.fragmentweather

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeatherShort : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapterShort

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather_short, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewWeather)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val weatherData = WeatherDataHolder.weatherData
        weatherAdapter = WeatherAdapterShort(weatherData)
        recyclerView.adapter = weatherAdapter
        return view
    }
}

