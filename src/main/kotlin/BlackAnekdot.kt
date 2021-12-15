import Comands.Command
import Comands.InitialState
import Comands.State
import Server.VkManager
import com.vk.api.sdk.objects.messages.Message

class BlackAnekdot(name: String = "чёрный") : Command(name) {
    override fun exec(message: Message) {
        if (State.actualState.name == AnekdotState().name) {
            State.setNewState(InitialState())
            VkManager().sendMessage("Два еврея хотели сбежать из концлагеря..... Но их спалили", message.peerId, null)
        } else {
            State.setNewState(InitialState())
            VkManager().sendMessage("Неизвестная команда", message.peerId, null)
        }
    }
}