package app.command

import app.command.collection.AddProductInCollection
import app.command.collection.ProductCollectionCommand

object CommandInterpretation {

    private val commands = HashMap<String, ProductCollectionCommand>()

    init {
        commands["add"] = AddProductInCollection
    }

    fun interpretation(message: String): ProductCollectionCommand? {
        val wordsInMessage = message.split(" ") as MutableList

        if (message.isNotEmpty()) {
            val iterator = wordsInMessage.listIterator()
            while (iterator.hasNext()) {
                if (iterator.next().isBlank()) {
                    iterator.remove()
                }
            }
            if (wordsInMessage.size > 2) return null
        } else {
            return null
        }

        if (commands.contains(wordsInMessage[0])) {
            val currentCommand = commands[wordsInMessage[0]]
            val typeOfParameter = currentCommand?.getTypeOfParameter()

           when(wordsInMessage.size){
               1 -> return if(typeOfParameter == null) currentCommand else null
               2 -> {
                   if(typeOfParameter != null){
                        if(typeOfParameter == String){
                            if(!currentCommand.setParameter(wordsInMessage[1])) return null
                            return currentCommand
                        }
                        else if(typeOfParameter == Int){
                            if(!currentCommand.setParameter(wordsInMessage[1].toInt())) return null
                            return currentCommand
                        }
                   } else {
                       return null
                   }
               }
           }
        }
        return null
    }

}

