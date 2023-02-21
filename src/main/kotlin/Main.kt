fun main(args: Array<String>) {

    while (true) {
        when (readLine()) {
            "/start" -> {
                println("Здравствуйте! Введите команду:")
                break
            }
            else -> println("Неверный формат данных, попробуйте еще раз.")
        }
    }

    while (true) {
        when (readLine()) {
            "/help" -> {
                println("Доступные команды:")
                println("/start - начало работы.")
                println("/help - вызов справки по командам.")
                println("/end - завершение работы и выход из программы.")
            }
            "/end" -> {
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