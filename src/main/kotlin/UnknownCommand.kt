import com.vk.api.sdk.objects.messages.Message

class UnknownCommand(name: String): Command(name) {
    override fun exec(message: Message) {
        VkManager().sendMessage("хуй", message.peerId)
    }
}