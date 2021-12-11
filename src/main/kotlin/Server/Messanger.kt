import com.vk.api.sdk.objects.messages.Message

class Messenger(private val message: Message) : Runnable {
    @ExperimentalStdlibApi
    override fun run() {
        execute(message)
    }
}