package app.command.cli

import app.command.AllCommandNames
import kotlin.reflect.KFunction
import kotlin.reflect.full.findParameterByName
import kotlin.reflect.full.primaryConstructor

object CommandInterpretation {


    fun interpretation(listOfWords: MutableList<String>): Pair<KFunction<Any>,Any>?{
        return checkIfMessageIsArgumentCommand(listOfWords)



    }

    private fun checkIfMessageIsArgumentCommand(listOfWords: MutableList<String>) : Pair<KFunction<Any>,Any>? {
        val possibleCommandName = listOfWords[0]

        for (name in AllCommandNames.argumentCommand.keys) {
            if (possibleCommandName == name && listOfWords.size == 2) {

                val instanceOfConstructor = createInstanceOfConstructorArgCommand(name)

                val typeOfArg = getTypeOfArg(instanceOfConstructor)

                return when(val  argument =  listOfWords[1].castTo(typeOfArg)){
                    is Outcome.Success -> Pair(instanceOfConstructor, argument)
                    is Outcome.Error -> null
                }
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

    private fun String.castTo(type: String) : Outcome<Any> = try {
            var castedArg: Any
            when (type) {
                "kotlin.Int" -> {
                    castedArg = this.toInt()
                    Outcome.Success(castedArg)
                }
                "kotlin.Double" -> {
                    castedArg = this.toDouble()
                    Outcome.Success(castedArg)
                }
            }
            castedArg = this
            Outcome.Success(castedArg)
        } catch (ex: NumberFormatException){
            Outcome.Error()
        }

    private fun <T> getTypeOfArg(constructor: KFunction<T>): String{
        return constructor.findParameterByName("arg")?.type.toString()
    }

    sealed class Outcome<out T : Any> {
        data class Success<out T : Any>(val value: T) : Outcome<T>()
        data class Error(val message: String? = null, val cause: Exception? = null) : Outcome<Nothing>()
    }
}