package main.kotlin

class Parking {
    private val parking = mutableMapOf<String, Car?>()

    init {
        for (i in 1..20) {
            parking["P${i}"] = null
        }
    }

    private fun returnFreePlace(): String? {
        return parking.entries.find { it.value == null }?.key
    }

    fun park(car: Car): String {
        val freePlace = returnFreePlace()
        if (freePlace != null) {
            parking.replace(freePlace, car)
            return "${car.owner} успешно припарковал свою $car на место $freePlace"
        } else {
            return "Вся парковка сейчас занята. Попробуйте припарковаться позже."
        }
    }

    fun unpark(car: Car): String {
        if (parking.containsValue(car)) {
            val place = parking.entries.find { it.value == car }?.key
            if (place != null) {
                parking.replace(place, null)
            }
            return "${car.owner} забрал $car"
        } else {
            return "На парковке нет такой машины. Проверьте правильность введенных данных."
        }
    }

    fun getInfoByPlace(place: String): String {
        if (parking.containsKey(place)) {
            val car = parking[place]
            return "$place: $car"
        } else {
            return "На парковке нет такого места. Проверьте правильность введенных данных."
        }
    }

    fun getInfoByCarNumber(number: String): String {
        val place = parking.entries.find { it.value?.number == number }?.key
        if (place != null) {
            return "Машина стоит на месте $place"
        } else {
            return "На парковке нет такой машины. Проверьте правильность введенных данных."
        }
    }
}