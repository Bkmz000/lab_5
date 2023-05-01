package app

import app.collection.ProductCollection
import app.command.CollectionInvoker
import app.command.CommandInterpretation

class App {
   fun start(){
       val message = readln()
       var com = CommandInterpretation.interpretation(message)
       if(com != null) CollectionInvoker.executeCommand(com) else println("No such command")
       println(ProductCollection.products)
       com = CommandInterpretation.interpretation(readln())
       if(com != null) CollectionInvoker.executeCommand(com) else println("No such command")
       println(ProductCollection.products)
       CollectionInvoker.undo()
       println(ProductCollection.products)
       CollectionInvoker.undo()
       println(ProductCollection.products)
       CollectionInvoker.undo()
    }
}