package app.command.argument

import app.command.ClientCommand

abstract class ArgumentCommand: ClientCommand(){

    abstract override fun execute(): String?
}