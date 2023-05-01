package app.command

import app.command.argument.InsertProduct
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer

object AllCommandNames {
    val argumentCommand = HashMap<String,String>()


    init {
        argumentCommand[InsertProduct.name] =  InsertProduct::class.toString().substringAfter(" ")
    }


}