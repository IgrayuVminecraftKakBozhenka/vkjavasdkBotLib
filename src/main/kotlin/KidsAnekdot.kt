import Comands.Command
import Comands.InitialState
import Comands.State
import Server.VkManager
import com.vk.api.sdk.objects.messages.Message

class KidsAnekdot(name: String = "детский") : Command(name) {

    override fun exec(message: Message) {
        if (State.actualState.name == AnekdotState().name) {
            State.setNewState(InitialState())
            VkManager().sendMessage("Как назвал своего сына кавказец парильщик? \n . \n . \n . \n . \n . \n Испарик", message.peerId, null)
        } else {
            State.setNewState(InitialState())
            VkManager().sendMessage("Неизвестная команда", message.peerId, null)
        }
    }
}