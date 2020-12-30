package tg

import org.telegram.abilitybots.api.bot.AbilityBot
import org.telegram.abilitybots.api.objects.Ability
import org.telegram.abilitybots.api.objects.Locality
import org.telegram.abilitybots.api.objects.MessageContext
import org.telegram.abilitybots.api.objects.Privacy

class TelegramDisPushBot(botToken: String?, botUsername: String?) : AbilityBot(botToken, botUsername) {
    constructor() : this("1443299748:AAE1Ss7eG0wLECiqQ5PjzBXVVT4Ph7vZk14", "pritonPushbot")

    var userChatPairs = mutableListOf<Pair<Int,Long>>(Pair(153823291,153823291), Pair(276941508,276941508))
    override fun creatorId() = 153823291

    fun replyToStart() = Ability
    .builder()
    .name("start")
    .info("start")
    .locality(Locality.ALL)
    .privacy(Privacy.PUBLIC)
    .action { ctx: MessageContext ->
        silent.send(
            "Теперь ты будешь получать надоедливые уведомления от меня" +
                    "вскоре, ты и вовсе меня возненавидишь, а пока, наслаждайся",
            ctx.chatId()
        )
        userChatPairs.add(Pair(ctx.user().id ,ctx.chatId()))
    }.build()


    fun sendMessage() {
        userChatPairs.forEach {
            silent.send("Кто-то вошел", it.second)
        }
    }


}