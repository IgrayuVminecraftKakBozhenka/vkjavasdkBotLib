import Comands.*
import Keyboards.getKeyboard
import Keyboards.getKeyboardButton
import Server.VkManager
import com.vk.api.sdk.objects.messages.*

class Anekdot(name: String = "анекдот") : Command(name) {

    private val allKeys = ArrayList<List<KeyboardButton>>()

    private val line1 = listOf(getKeyboardButton("Детский", TemplateActionTypeNames.TEXT, KeyboardButtonColor.PRIMARY),
        getKeyboardButton("Чёрный", TemplateActionTypeNames.TEXT, KeyboardButtonColor.NEGATIVE),
        getKeyboardButton("Про хохлов", TemplateActionTypeNames.TEXT, KeyboardButtonColor.POSITIVE))

    init {
        allKeys.add(line1)
    }

    override fun exec(message: Message) {

        val keyboard = getKeyboard(allKeys)
        if (State.actualState.name == InitialState().name) {
            State.setNewState(AnekdotState())
            VkManager().sendMessage("Внимание анекдот... \n Выберите анекдот", message.peerId, keyboard)
        } else {
            VkManager().sendMessage("Неизвестная команда", message.peerId, null)
            State.setNewState(InitialState())
        }
    }
}

