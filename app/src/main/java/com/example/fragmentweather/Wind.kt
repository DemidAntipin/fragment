package com.example.fragmentweather

import android.content.Context
import com.example.fragmentweather.MainActivity

class Wind {
    var deg: Int = 0
    var direction: String = "Северный ветер"

    fun updateWindDirection(context: Context) {
        this.deg = deg % 360
        val directions = context.resources.getStringArray(R.array.wind_directions)
        direction = when {
            this.deg >= 337 || this.deg < 23 -> directions[0]
            this.deg in 23..68 -> directions[1]
            this.deg in 68..113 -> directions[2]
            this.deg in 113..158 -> directions[3]
            this.deg in 158..203 -> directions[4]
            this.deg in 203..248 -> directions[5]
            this.deg in 248..293 -> directions[6]
            this.deg in 293..337 -> directions[7]
            else -> directions[8]
        }
    }
}