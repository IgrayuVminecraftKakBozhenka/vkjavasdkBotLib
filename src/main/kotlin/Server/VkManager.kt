package Server

import Core
import com.vk.api.sdk.objects.messages.Keyboard
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

    fun sendMessage(msg: String?, peerId: Int, keyboard: Keyboard?) {
        if (msg == null) {
            println("empty message")
            return
        }
        try {
            if (keyboard != null) {
                vkCore?.vkApiClient?.messages()?.send(vkCore?.groupActor)?.message(msg)?.peerId(peerId)?.randomId(Random.nextInt())?.keyboard(keyboard)?.execute()
            } else {
                vkCore?.vkApiClient?.messages()?.send(vkCore?.groupActor)?.message(msg)?.peerId(peerId)?.randomId(Random.nextInt())?.execute()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}