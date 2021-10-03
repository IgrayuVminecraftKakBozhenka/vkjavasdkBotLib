import com.vk.api.sdk.objects.messages.Message

fun getCommand(commands: Collection<Command>, message: Message): Command {
    val body = message.text

    commands.forEach { command ->
        if (command.name.equals(body.lowercase())) {
            return command
        }
    }
    return UnknownCommand("unknown")
}

fun execute(message: Message) {
    getCommand(CommandManager.getCommands(), message).exec(message)
}