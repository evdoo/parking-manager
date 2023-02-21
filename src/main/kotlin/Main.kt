fun main(args: Array<String>) {

    while (true) {
        if (readLine().equals("/start")) {
            println("Здравствуйте! Введите команду:")
            break
        } else {
            println("Неверный формат данных, попробуйте еще раз.")
        }
    }

    while (true) {
        val input = readLine()
        if (input.equals("/help")) {
            println("Доступные команды:\n/start - начало работы.\n/help - вызов справки по командам.\n/end - завершение работы и выход из программы.")
        } else if (input.equals("/end")) {
            println("До свидания. Хорошего дня")
            break
        } else {
            println("Неверный формат данных, попробуйте еще раз.\nДля вызова справки используйте команду /help")
        }
    }
}