import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder

const val BOT_TOKEN: String = "NzkzNTY4NzExOTY0NDkxODQ3.X-uKdA.8Bok2J7Rb2JFNLXPJTtvUq4EX38"

fun main() {
    startDisBot()
    startTelegramBot()
}

fun startDisBot() {
    val builder: JDABuilder = JDABuilder.createDefault(BOT_TOKEN)
}

fun startTelegramBot() {

}