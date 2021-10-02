import com.vk.api.sdk.client.VkApiClient
import com.vk.api.sdk.client.actors.GroupActor
import com.vk.api.sdk.httpclient.HttpTransportClient

var groupId: Int = 0
var accessToken: String = ""
val actor = GroupActor(203148566,"b99c377d206b1528a1ce0ceba00c195e2ccafd6b3aee991e1e213522d013129e2c0a814290346fe5485fa")
val vkApiClient =  VkApiClient(HttpTransportClient.getInstance())
val ts = vkApiClient.messages().getLongPollServer(actor).execute().ts

fun main() {
    val core = Core(4234234, "")
}