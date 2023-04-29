package app.command.collection

import app.collection.ProductCollection
import product.Product
import java.util.TreeMap

abstract class ProductCollectionCommand (private val collection: ProductCollection) {
    private var preCommandState = TreeMap<Int, Product>()

    abstract fun execute()

    fun saveState(){
        preCommandState = TreeMap<Int, Product>(collection.products)
    }

    fun undo(){
        println("undo $this")
        collection.products = TreeMap<Int,Product>(preCommandState)
    }
}