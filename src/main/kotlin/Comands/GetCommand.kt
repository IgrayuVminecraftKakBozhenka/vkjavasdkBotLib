import Comands.Command
import Comands.CommandManager
import com.vk.api.sdk.objects.messages.Message

@ExperimentalStdlibApi
fun getCommand(commands: Collection<Command>, message: Message): Command {
    val body = message.text

    commands.forEach { command ->
        if (command.name == body.lowercase()) {
            return command
        }
    }
    return UnknownCommand("unknown")
}

@ExperimentalStdlibApi
fun execute(message: Message) {
    getCommand(CommandManager.getCommands(), message).exec(message)
}