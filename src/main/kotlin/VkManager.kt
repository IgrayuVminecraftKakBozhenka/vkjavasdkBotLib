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
        if (msg != null) {
            println("empty message")
        }
    }

}