import com.vk.api.sdk.client.VkApiClient
import com.vk.api.sdk.client.actors.GroupActor
import com.vk.api.sdk.exceptions.ClientException
import com.vk.api.sdk.httpclient.HttpTransportClient
import com.vk.api.sdk.objects.messages.Message

class Core(
    private val groupId: Int = GROUP_ID,
    private val accessToken: String = ACCESS_TOKEN,
    val groupActor: GroupActor = GroupActor(groupId, accessToken),
    val vkApiClient: VkApiClient = VkApiClient(HttpTransportClient.getInstance()),
) {

    companion object {
        private var ts: Int = 0
        private var maxMsgId = -1
    }

    init {
        ts = vkApiClient.messages().getLongPollServer(groupActor).execute().ts
    }

    fun getMessage(): Message? {

        val eventsQuery = vkApiClient.messages()
            .getLongPollHistory(groupActor)
            .ts(ts)

        if (maxMsgId > 0) {
            eventsQuery.maxMsgId(maxMsgId)
        }

        val messages: List<Message> = eventsQuery
            .execute()
            .messages
            .items

        if (messages.isNotEmpty()) {
            try {
                ts = vkApiClient.messages()
                    .getLongPollServer(groupActor)
                    .execute()
                    .ts
            } catch (e: ClientException) {
                e.printStackTrace()
            }
        }

        if (messages.isNotEmpty() && !messages[0].isOut) {
            val messageId = messages[0].id
            if (messageId > maxMsgId) {
                maxMsgId = messageId
            }
            return messages[0]
        }
        return null
    }
}