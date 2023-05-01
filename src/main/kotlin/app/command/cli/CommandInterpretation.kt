package app.command.cli

import app.command.AllCommandNames
import kotlin.reflect.KFunction
import kotlin.reflect.full.findParameterByName
import kotlin.reflect.full.primaryConstructor

object CommandInterpretation {


    fun interpretation(listOfWords: MutableList<String>): Pair<KFunction<Any>,Any>?{
        return checkIfMessageIsArgumentCommand(listOfWords) ?: null



    }

    private fun checkIfMessageIsArgumentCommand(listOfWords: MutableList<String>) : Pair<KFunction<Any>,Any>? {
        val possibleCommandName = listOfWords[0]

        for (name in AllCommandNames.argumentCommand.keys) {
            if (possibleCommandName == name && listOfWords.size == 2) {

                val instanceOfConstructor = createInstanceOfConstructorArgCommand(name)

                val typeOfArg = getTypeOfArg(instanceOfConstructor)
                val argument =  listOfWords[1].convertTo(typeOfArg)
                return Pair(instanceOfConstructor, argument)
            }
        }
        return null
    }


    private fun createInstanceOfConstructorArgCommand(commandName : String): KFunction<Any>{
        try {
            val command = Class.forName(AllCommandNames.argumentCommand[commandName]).kotlin
            return command.primaryConstructor!!
        } catch (e: ClassNotFoundException) {
            throw Error("There is no this command in AllCommandManes")
        }
    }

    private fun String.convertTo(type: String) : Any{
        when(type){
            "kotlin.Int" -> return this.toInt()
            "kotlin.Double" -> return this.toDouble()
        }
        return this
    }
    private fun <T> getTypeOfArg(constructor: KFunction<T>): String{
        return constructor.findParameterByName("arg")?.type.toString()
    }
}