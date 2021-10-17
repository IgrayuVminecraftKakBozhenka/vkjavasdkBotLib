package Comands

import com.vk.api.sdk.objects.messages.Message



abstract class Command(var name: String) {

    abstract fun exec(message: Message)

    override fun toString(): String {
        return "name: $name"
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other is Command) {
            if (name == other.name) {
                return true
            }
        }
        return false
    }
}


