object CommandManager {
    private val commands = HashSet<Command>()

    fun addCommand(command: Command) {
        commands.add(command)
    }

    fun getCommands() = commands
}