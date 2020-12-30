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
import java.lang.reflect.Member

class EntryListener : ListenerAdapter() {

    override fun onGuildVoiceJoin(event: GuildVoiceJoinEvent) {
        val memberName: String = event.member.effectiveName
        val onJoinMessage = EmbedBuilder()

        onJoinMessage.setDescription("$memberName зашел в хату")
        event.jda.textChannels[0].sendMessage(onJoinMessage.build()).submit()

        if (event.channelJoined.members.size == 1) {
            event.jda.textChannels[0].sendMessage("-play https://www.youtube.com/watch?v=VBlFHuCzPgY&ab_channel=AntoineB")
                .submit()
        }
    }

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.message.contentDisplay == "А") {
            event.textChannel.sendMessage("Хуй на").submit()
        }
    }

}