package app.command.argument

import app.command.ClientCommand

abstract class ArgumentCommand(open val arg:Any): ClientCommand() {

    abstract override fun execute(): String?
}