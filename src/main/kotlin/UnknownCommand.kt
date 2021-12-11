import Comands.Command
import Comands.InitialState
import Comands.State
import Server.VkManager
import com.vk.api.sdk.objects.messages.Message

class UnknownCommand(name: String): Command(name) {
    override fun exec(message: Message) {
        State.setNewState(InitialState())
        VkManager().sendMessage("Неизвестная команда", message.peerId, null)
    }
}