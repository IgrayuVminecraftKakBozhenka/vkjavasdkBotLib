import kotlin.random.Random

class VkManager {

    companion object {
        var vkCore: Core? = null
    }


    init {
        try {
            vkCore = Core()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun sendMessage(msg: String?, peerId: Int) {
        if (msg == null) {
            println("empty message")
            return
        }
        try {
            vkCore?.vkApiClient?.messages()?.send(vkCore?.groupActor)?.message(msg)?.peerId(peerId)?.randomId(Random.nextInt())?.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}