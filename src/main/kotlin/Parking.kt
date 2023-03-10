package main.kotlin

class Parking {
    private val parking = mutableMapOf<String, Car?>()

    init {
        for (i in 1..20) {
            parking["P${i}"] = null
        }
    }
}