package com.example.fragmentweather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeatherShort : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherAdapterShort
    private lateinit var weatherList: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather_short, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewWeather)
        recyclerView.layoutManager = LinearLayoutManager(context)

        weatherList = listOf("Сегодня: 25°C - Солнечно", "Завтра: 18°C - Дождь", "Четверг: 0°C - Снег")
        weatherAdapter = WeatherAdapterShort(weatherList)

        recyclerView.adapter = weatherAdapter

        return view
    }
}

