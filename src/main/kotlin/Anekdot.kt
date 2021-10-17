import Comands.Command
import Keyboards.getKeyboardButton
import Server.VkManager
import com.vk.api.sdk.objects.messages.*

class Anekdot(name: String = "анекдот") : Command(name) {

    val allKeys = ArrayList<List<KeyboardButton>>()

    val line1 = listOf(getKeyboardButton("Синия", TemplateActionTypeNames.TEXT, KeyboardButtonColor.PRIMARY),
        getKeyboardButton("Красная", TemplateActionTypeNames.TEXT, KeyboardButtonColor.NEGATIVE),
        getKeyboardButton("Зеленая", TemplateActionTypeNames.TEXT, KeyboardButtonColor.POSITIVE))



    override fun exec(message: Message) {
        allKeys.add(line1)
        val keyboard = Keyboard().setButtons(allKeys)
        VkManager().sendMessage("Внимание анекдот..................", message.peerId, keyboard)
    }
}