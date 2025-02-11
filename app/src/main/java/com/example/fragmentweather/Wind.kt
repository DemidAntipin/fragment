package com.example.fragmentweather

class Wind {
    var deg: Int = 0
    var direction: String = "Северный ветер"

    fun updateWindDirection(deg: Int) {
        this.deg = deg % 360
        direction = when {
            this.deg >= 337 || this.deg < 23 -> "Северный ветер"
            this.deg in 23..68 -> "Северо-восточный ветер"
            this.deg in 68..113 -> "Восточный ветер"
            this.deg in 113..158 -> "Юго-восточный ветер"
            this.deg in 158..203 -> "Южный ветер"
            this.deg in 203..248 -> "Юго-западный ветер"
            this.deg in 248..293 -> "Западный ветер"
            this.deg in 293..337 -> "Северо-западный ветер"
            else -> "Неизвестное направление"
        }
    }
}
