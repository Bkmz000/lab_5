package app.command

import app.command.collection.ProductCollectionCommand
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.drop
import java.util.concurrent.Executors

object CommandProcessor {

    private val commands = Channel<ProductCollectionCommand>()
    private val processScope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())
    private val executeScope = CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher())


    fun process(command: ProductCollectionCommand){
        processScope.launch {
            commands.send(command)
        }

    }

    init {

        executeScope.launch {
            for (command in commands){
                command.execute()
            }
        }
    }




}