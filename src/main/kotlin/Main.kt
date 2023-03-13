import main.kotlin.Command
import main.kotlin.Manager

private val manager: Manager = Manager()
fun main(args: Array<String>) {

    while (true) {
        when (readLine()) {
            Command.START.command -> {
                println("Здравствуйте! Введите команду:")
                break
            }
            else -> println("Неверный формат данных, попробуйте еще раз.")
        }
    }

    while (true) {
        when (readLine()) {
            Command.HELP.command -> {
                println("Доступные команды:")
                println("/start - начало работы.")
                println("/help - вызов справки по командам.")
                println("/end - завершение работы и выход из программы.")
            }
            Command.END.command -> {
                println("До свидания. Хорошего дня")
                break
            }
            else -> {
                println("Неверный формат данных, попробуйте еще раз.")
                println("Для вызова справки используйте команду / help")
            }
        }
    }
}