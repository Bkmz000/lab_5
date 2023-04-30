package app.command.collection

import app.collection.ProductCollection
import product.Coordinates
import product.Product
import product.UnitOfMeasure

class AddProductInCollection(val id: Int, collection: ProductCollection) : ProductCollectionCommand(collection) {

   private val product = Product.Builder()

   override suspend fun execute() {
       saveState()
       println("Write down the fields values:")
       getName()
       getCoordinate()
       getPrice()
       getUnitOfMeasure()
       val ex =  product.build()
       if(ex != null) collection.products.put(id,ex)
   }

   private fun getName(){
       product.name(customReadLine("name: ") { s: String -> true })
   }

   private fun getCoordinate(){
       println("coordinate: ")
       val x = customReadLine("x: ") {s: String -> s.toIntOrNull() != null}
       val y = customReadLine("y: ") {s: String -> s.toDoubleOrNull() != null}
       product.coordinates(Coordinates(x.toInt(),y.toDouble()))
   }

    private fun getPrice(){
        val price = customReadLine("price: ") { s: String -> s.toIntOrNull() != null }
        product.price(price.toInt())
    }
    private fun getUnitOfMeasure(){
        fun checkIfUnitOfMeasure(s:String):Boolean{
            try {
                UnitOfMeasure.valueOf(s)
            } catch (e: IllegalArgumentException){
                return false
            }
            return true
        }
        val unitOfMeasure = customReadLine("unit if measure: ${enumValues<UnitOfMeasure>().asList()} ") { s:String -> checkIfUnitOfMeasure(s) }
        product.unitOfMeasure(UnitOfMeasure.valueOf(unitOfMeasure))
    }


    private fun customReadLine(prefixString: String,condition: (String) -> Boolean): String{
        var messageFromUser:String
        while (true){
            print(prefixString)
            readln().also { messageFromUser = it }
            if(messageFromUser.isNotEmpty()){
                if(condition(messageFromUser)){
                    return messageFromUser
                }
            }
            println("Message is incorrect. Please try again!")
        }
    }


}