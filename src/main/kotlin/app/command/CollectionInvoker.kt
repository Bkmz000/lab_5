package app.command

import app.command.collection.ProductCollectionCommand

object CollectionInvoker {
    private val commands = mutableListOf<ProductCollectionCommand>()

    fun executeCommand(command: ProductCollectionCommand){
        commands.add(command)
        command.execute()
    }

    fun undo(){
        if(commands.isNotEmpty()){
            commands.removeLast().undo()
        }
    }
}