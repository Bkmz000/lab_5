package app.command.collection

import app.collection.ProductCollection
import product.Product

class AddProductInCollection(val id: Int, collection: ProductCollection) : ProductCollectionCommand(collection) {

   private var currentField: Fields = Fields.NAME
   private val fields = listOf<Fields>(Fields.NAME,Fields.COORDINATES,Fields.PRICE,Fields.UNIT_OF_MEASURE,Fields.MANUFACTURER)
   private var isEnough = false
   private val product = Product.Builder()

   override fun execute() {
       saveState()
       var isEnd = false
       while(!isEnd){
           println("Write down the fields values:")
           ::getName

       }

   }

   private fun getName(){
       println("name: ")
       product.name = customReadLine(it: String -> it != null)
   }

   private fun getCoordinate(){
       println("coordinate: ")
       println("x: ")
       val x = customReadLine().toInt()
       println("y: ")
       val y = customReadLine().toInt()
   }
    private fun get
    private fun customReadLine(condition: String?.() -> Boolean): String?{
        var messageFromUser:String?
        var isCorrect = false
        while (!isCorrect){
            messageFromUser = readlnOrNull()
            if(condition(messageFromUser)){
                return messageFromUser
                isCorrect = true
            } else {
                println("Message is incorrect. Please try again!")
            }
        }
        return throw Error("Error")
    }

    private interface Condition{
        fun check(s: String): Boolean
    }




   private enum class Fields {
        NAME,
        COORDINATES,
        PRICE,
        UNIT_OF_MEASURE,
        MANUFACTURER,
   }


}