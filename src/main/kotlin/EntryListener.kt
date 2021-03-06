import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.GuildVoiceState
import net.dv8tion.jda.api.entities.VoiceChannel
import net.dv8tion.jda.api.events.GenericEvent
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.EventListener
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.hooks.VoiceDispatchInterceptor
import net.dv8tion.jda.api.utils.data.DataObject
import tg.TelegramDisPushBot
import java.lang.reflect.Member

class EntryListener(telegramBot: TelegramDisPushBot) : ListenerAdapter() {
    val tgBot = telegramBot

    override fun onGuildVoiceJoin(event: GuildVoiceJoinEvent) {
        val memberName: String = event.member.effectiveName
        val onJoinMessage = EmbedBuilder()

        onJoinMessage.setDescription("$memberName зашел в хату")
        event.jda.textChannels[0].sendMessage(onJoinMessage.build()).submit()
        tgBot.sendMessage(memberName, event.channelJoined.name)
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.message.contentDisplay == "А") {
            event.textChannel.sendMessage("Хуй на").submit()
        }
    }

}