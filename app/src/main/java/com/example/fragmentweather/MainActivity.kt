package com.example.fragmentweather

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction
    lateinit var fr1: Fragment
    lateinit var fr2: Fragment
    lateinit var toFinishTask: Button
    lateinit var toCurrentTask: Button
    lateinit var weather: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        val fr = fm.findFragmentById(R.id.frame_container)
        weather = findViewById(R.id.loadWeatherButton)

        val citySpinner: Spinner = findViewById(R.id.city_spinner)
        val cities = resources.getStringArray(R.array.cities_array)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citySpinner.adapter = adapter

        toCurrentTask = findViewById(R.id.currentTask)
        toFinishTask = findViewById(R.id.finishTask)
        weather.setOnClickListener{
            lifecycleScope.launch {
                val selectedCity = citySpinner.selectedItem.toString()
                loadWeather(selectedCity)

                fr2 = WeatherFull()
                if (fr == null) {
                    fr1 = WeatherShort()
                    fm.beginTransaction().add(R.id.frame_container, fr1).commit()
                } else {
                    fr1 = fr
                }
                toFinishTask.setOnClickListener {
                    val ft = fm.beginTransaction()
                    ft.replace(R.id.frame_container, fr2)
                    ft.commit()
                }

                toCurrentTask.setOnClickListener {
                    val ft = fm.beginTransaction()
                    ft.replace(R.id.frame_container, fr1)
                    ft.commit()
                }
            }
        }
    }

    suspend fun loadWeather(selectedcity: String) {
        withContext(Dispatchers.IO) {
            try {
                val API_KEY = getString(R.string.api_key)
                val weatherURL =
                    "https://api.openweathermap.org/data/2.5/weather?q=$selectedcity&appid=$API_KEY&units=metric"
                val stream = URL(weatherURL).getContent() as InputStream
                val gson = Gson()
                val weatherData: Weather_ =
                    gson.fromJson(InputStreamReader(stream), Weather_::class.java)
                WeatherDataHolder.weatherData.add(weatherData)

            } catch (e: Exception) {
                Log.d("mytag", "Error loading weather data: ${e.message}")
            }
        }
    }
}

object WeatherDataHolder {
    val weatherData:  MutableList<Weather_> = mutableListOf()
}