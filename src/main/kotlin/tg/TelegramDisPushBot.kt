package tg

import org.telegram.abilitybots.api.bot.AbilityBot
import org.telegram.abilitybots.api.objects.Ability
import org.telegram.abilitybots.api.objects.Locality
import org.telegram.abilitybots.api.objects.MessageContext
import org.telegram.abilitybots.api.objects.Privacy

class TelegramDisPushBot(botToken: String?, botUsername: String?) : AbilityBot(botToken, botUsername) {
    constructor() : this("1443299748:AAE1Ss7eG0wLECiqQ5PjzBXVVT4Ph7vZk14", "pritonPushbot")

    var usersMap = mutableMapOf<Long, String>(Pair(153823291,"andrewen"), Pair(276941508, "刀口仁口仁仈"))
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
                    "вскоре, ты и вовсе меня возненавидишь, а пока, наслаждайся" +
                    "Укажи свой ник в discord, с помощью команды '/nick твой_ник'",

            ctx.chatId()
        )
        usersMap.put(ctx.chatId(), "")
    }.build()

    fun replyToNick() = Ability
            .builder()
            .name("nick")
            .info("nick")
            .locality(Locality.ALL)
            .privacy(Privacy.PUBLIC)
            .action{ctx: MessageContext ->
                val nick = ctx.update().message.text.split(" ").last()
                usersMap.put(ctx.chatId(), nick)

                silent.send("я изменил твой ник", ctx.chatId())
            }.build()

    fun sendMessage(member: String, voiceChannel: String = "") {
        usersMap.forEach {pair ->
            if (member != pair.value)
                silent.send("$member вошел в голосовой чат $voiceChannel", pair.key)
        }
    }
}