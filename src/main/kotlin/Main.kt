import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import tg.TelegramDisPushBot
import java.lang.Thread.sleep


const val BOT_TOKEN: String = "NzkzNTY4NzExOTY0NDkxODQ3.X-uKdA.8Bok2J7Rb2JFNLXPJTtvUq4EX38"
lateinit var jda: JDA

fun main() {
    startDisBot(startTelegramBot())
}

fun startDisBot(tgBot: TelegramDisPushBot) {
    jda = JDABuilder.createDefault(BOT_TOKEN).build()
    jda.addEventListener(EntryListener(tgBot))
}

fun startTelegramBot(): TelegramDisPushBot {

    val botsApi = TelegramBotsApi(DefaultBotSession::class.java)

    val botOptions = DefaultBotOptions()
    val bot = TelegramDisPushBot()
    try {
        botsApi.registerBot(bot)
    } catch (e: TelegramApiException) {
        e.printStackTrace()
    }
    return bot
}