package app

import app.collection.ProductCollection
import app.command.CommandProcessor
import app.command.collection.AddProductInCollection
import product.Coordinates
import product.Product
import product.UnitOfMeasure

class App {
   fun start(){

        val col = ProductCollection()
        val add = AddProductInCollection(1,col)
        CommandProcessor.process(add)
       println(col.products[1])





    }
}