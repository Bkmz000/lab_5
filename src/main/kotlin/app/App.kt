package app

import app.collection.ProductCollection
import app.command.AllCommandNames
import app.command.ClientCommand
import app.command.argument.InsertProduct
import app.command.cli.CommandInterpretation
import app.command.cli.CommandReaderCLI
import kotlin.reflect.KClass
import kotlin.reflect.full.*
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.reflect

class App {
   @OptIn(ExperimentalStdlibApi::class)
   fun start(){
       val a = CommandReaderCLI.readCommand()

       val b = a?.let { CommandInterpretation.interpretation(it) }



       val c =  b?.first?.call(b.second)
       if(c!= null){
           val m = c as ClientCommand
           m.execute()
       } else {

       }
       println(ProductCollection.products)
//        val n: KClass<Int> = Int::class
//       println(n)


//       val a = Class.forName(AllCommandNames.argumentCommand["insert"]).kotlin
//       val b = a.primaryConstructor!!
//        var c = a::class.va
//       println(c)
//       val g = Class<Int>::kotlin
//       println(g)


       }



//       val cls = Class.forName(AllCommandNames.argumentCommand[0]).kotlin
//       val ctor = cls.primaryConstructor!!
//       val gfjg = ctor.call(1)
//       println(gfjg)

//        val a: String = InsertProduct::class.toString().substringAfter(" ")
//       println(a)

   }
