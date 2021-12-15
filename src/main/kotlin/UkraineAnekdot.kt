import Comands.Command
import Comands.InitialState
import Comands.State
import Server.VkManager
import com.vk.api.sdk.objects.messages.Message

class UkraineAnekdot(name: String = "про хохлов") : Command(name) {
    override fun exec(message: Message) {
        if (State.actualState.name == AnekdotState().name) {
            State.setNewState(InitialState())
            VkManager().sendMessage("Украинец съездил по турпутевке в Испанию, рассказывает про корриду:\n" +
                    "— Ну, арена така гарна, на трыбунах – испански чоловикы вси таки гарни, спокийни, " +
                    "испанские жинки – гарни, спокийни, выпустили быка на арену – вэлыкый такый бык, спокийный," +
                    " тореадор вышел – гарный, спокийный…И тут тореадор достал комуняцький флаг! И вси як з ума посходили!!!", message.peerId, null)
        } else {
            State.setNewState(InitialState())
            VkManager().sendMessage("Неизвестная команда", message.peerId, null)
        }
    }
}