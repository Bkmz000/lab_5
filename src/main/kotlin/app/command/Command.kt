package app.command

interface Command {
    fun execute(args: Array<String>)
}