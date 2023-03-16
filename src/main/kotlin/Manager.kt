package main.kotlin

import java.lang.StringBuilder

class Manager(private val view: View) {
    private val parking: Parking = Parking()
    private var statistics: Int = 0

    fun recognizeCommand(str: String) {
        val arguments = str.split(" ")

        if (arguments.isEmpty()) {
            view.showStatus(createErrorStatus())
        } else {
            when (arguments[0]) {
                Command.PARK.command -> {
                    val status = park(arguments)
                    view.showStatus(status)
                }
                Command.PARK_INFO_BY_CAR.command -> {
                    val status = getInfoByCarNumber(arguments)
                    view.showStatus(status)
                }
                Command.PARK_INFO_BY_PLACE.command -> {
                    val status = getInfoByPlace(arguments)
                    view.showStatus(status)
                }
                Command.RETURN.command -> {
                    val status = returnCar(arguments)
                    view.showStatus(status)
                }
                Command.HELP.command -> {
                    val status = StringBuilder()
                    status.append("Доступные команды:\n")
                    status.append("/start - начало работы.\n")
                    status.append("/return - возвращает указанную машину владельцу.\n")
                    status.append("/park - припарковывает указанную машину на любое свободное место.\n")
                    status.append("/park_info_by_car - возвращает место, где припаркована машина, по ее номеру.\n")
                    status.append("/park_info_by_place - возвращает информацию о машине по месту на парковке.\n")
                    status.append("/help - вызов справки по командам.\n")
                    status.append("/end - завершение работы и выход из программы.\n")
                    view.showStatus(status.toString())
                }
                Command.END.command -> {
                    view.endProgram("До свидания. Хорошего дня")
                }
                else -> {
                    val status = createErrorStatus()
                    view.showStatus(status)
                }
            }
        }
    }

    private fun returnCar(arguments: List<String>): String {
        if (arguments.size != 4) {
            return createErrorStatus()
        } else {
            val car = Car(
                "",
                "",
                arguments[1],
                Owner(
                    arguments[2],
                    arguments[3]
                )
            )
            return parking.unpark(car)
        }
    }

    private fun getInfoByPlace(arguments: List<String>): String {
        if (arguments.size != 2) return createErrorStatus()
        else return parking.getInfoByPlace(arguments[1])
    }

    private fun getInfoByCarNumber(arguments: List<String>): String {
        if (arguments.size != 2) return createErrorStatus()
        else return parking.getInfoByCarNumber(arguments[1])
    }

    private fun park(arguments: List<String>): String {
        if (arguments.size != 6) {
            return createErrorStatus()
        } else {
            val car = Car(
                arguments[2],
                arguments[1],
                arguments[3],
                Owner(
                    arguments[4],
                    arguments[5]
                )
            )
            return parking.park(car)
        }
    }

    private fun createErrorStatus(): String {
        val status = StringBuilder()
        status.append("Неверный формат данных, попробуйте еще раз.\n")
        status.append("Для вызова справки используйте команду /help")
        return status.toString()
    }
}