import Comands.CommandManager
import com.vk.api.sdk.exceptions.ApiException
import java.util.concurrent.Executors


object VkServer {
    var vkCore: Core? = null

    init {
        try {
            vkCore = Core()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws(NullPointerException::class, ApiException::class, InterruptedException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Start")
        CommandManager.addCommand(UnknownCommand("unknown"))
        CommandManager.addCommand(Anekdot())
        while (true) {
            Thread.sleep(300)
            try {
                val message = vkCore?.getMessage()
                if (message != null) {
                    val exec = Executors.newCachedThreadPool()
                    exec.execute(Messenger(message))
                }
            } catch (e: Exception) {
                println("Oooops... problem")
                val reconnectTime = 10000L
                print("reconnect after $reconnectTime millisecond")
                Thread.sleep(reconnectTime)
            }
        }
    }
}


