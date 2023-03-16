import main.kotlin.Command
import main.kotlin.Manager
import main.kotlin.View
import kotlin.system.exitProcess

class Main : View {
    private val manager: Manager = Manager(this)
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
            val str = readLine()
            val command = manager.recognizeCommand(str!!)
        }
    }

    override fun showStatus(status: String) {
        println(status)
    }

    override fun endProgram(message: String) {
        println(message)
        exitProcess(0)
    }
}